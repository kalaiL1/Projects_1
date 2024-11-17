-- exploratory data analysis
-- get insights from the dataset
select * from dupli_layoffs;

select max(total_laid_off),min(total_laid_off)
from dupli_layoffs;
select max(percentage_laid_off),min(percentage_laid_off)
from dupli_layoffs;
select max(`date`),min(`date`)
from dupli_layoffs;


select company,sum(total_laid_off)
from dupli_layoffs 
group by company
order by 2 desc;

select industry,sum(total_laid_off)
from dupli_layoffs 
group by industry
order by 2 desc;

select country,sum(total_laid_off)
from dupli_layoffs 
group by country
order by 2 desc;

select year(`date`),avg(total_laid_off)
from dupli_layoffs 
group by year(`date`)
order by 2 desc;

select stage,sum(total_laid_off)
from dupli_layoffs 
group by stage
order by 2 desc;

select * from dupli_layoffs;


select substring(`date`,1,7) as mon,sum(total_laid_off)
from dupli_layoffs
group by substring(`date`,1,7)
order by 1 ;
-- rolling total
with ex1 as(
select substring(`date`,1,7) as mon,sum(total_laid_off) as tot
from dupli_layoffs
group by substring(`date`,1,7)
)
select mon,sum(tot)over(order by mon)as roll_tot
from ex1
where mon is not null;

-- getting company ranks respect to total laidoffs and year
select company,year(`date`),sum(total_laid_off) from dupli_layoffs
where year(`date`) is not null
group by company,year(`date`)
order by 1;

with ex2 (company,years,tot_layoffs)as(
select company,year(`date`),sum(total_laid_off) from dupli_layoffs
group by company,year(`date`)
order by 1)
,company_year(company,years,tot_layoffs,ranks) as(
select * ,dense_rank()
over(partition by years order by tot_layoffs desc) 
  from ex2
  where years is not null
)
select* from 
company_year
where ranks<=3
order by years,ranks;









