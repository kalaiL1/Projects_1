select * from c_layoffs;
-- data cleaning
-- 1.remove duplicates
-- 2.standardize the values
-- 3.null values or missing values
-- 4.remove any unneccsary rows and colums

-- dont do any changes in imported raw data
create table layout_infos
like c_layoffs;

insert layout_infos
select * from
c_layoffs;

select * from layout_infos;


with ex1 as(
select * ,row_number()
over(partition by company,location,industry,total_laid_off,percentage_laid_off,`date`,stage,country,funds_raised_millions ) as na
from layout_infos)
select * from ex1 where company='casper' ;

-- creating duplicate table for removing duplicate values
create table dupli_layoffs
select * ,row_number()
over(partition by company,location,industry,total_laid_off,percentage_laid_off,`date`,stage,country,funds_raised_millions ) as na
from layout_infos;

select * from dupli_layoffs;

-- delete dulicate colums
delete from dupli_layoffs
where na>1;

-- 2.standardize(go column by column)
-- 1
select company,trim(company)
from dupli_layoffs;

update dupli_layoffs
set company=trim(company);
-- 2
select distinct location from dupli_layoffs
where location like 'b%';
-- 3
select distinct industry from 
dupli_layoffs
where industry like 'c%';

update dupli_layoffs
set industry='Cryptocurrency'
where industry in ('crypto','crypto currency');

-- 4
select * from dupli_layoffs;
select distinct country from dupli_layoffs
order by 1;

select distinct country from 
dupli_layoffs
where country like 'u%';

update dupli_layoffs
set country='United States'
where country='UNited States.';
  
-- 5 date format(%y-takes two digits %Y-takes 4 digits)
select `date`,str_to_date(`date`,'%m/%d/%Y') as new_date from dupli_layoffs;
update dupli_layoffs
set `date`=str_to_date(`date`,'%m/%d/%Y');

alter table dupli_layoffs
modify column `date` date;

-- 3.null values
select * from dupli_layoffs;

select * from
dupli_layoffs
where total_laid_off is null and percentage_laid_off is null;

select * from
dupli_layoffs
where industry='' or industry is null;
select * from
dupli_layoffs
where country='' or country is null;

update dupli_layoffs
set industry=null
where industry='';

select t1.industry,t2.industry from dupli_layoffs t1
join dupli_layoffs t2
on t1.company=t2.company
where (t1.industry='' or t1.industry is null)
and t2.industry is not null;

update dupli_layoffs t1
join dupli_layoffs t2
on t1.company=t2.company
set t1.industry=t2.industry
 where  t1.industry is null
 and t2.industry is not null;
 
 select * from
 dupli_layoffs where company like 'Bally%';
 
 -- 4 remove columns
-- removing na

alter table dupli_layoffs
drop column na;

