import java.util.*;

public class Main {
    public static void main(String[] args) {
      String k="701";
      String []singledigit = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
      String []twodigits=new String[] {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen"};
      String []tensmultiple = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};
      String []tenspower =new String[] {"hundred", "thousand"};
      int len=k.length();
      if(len==0){
        System.out.print("");
      }
      if(len==1){
        System.out.print(singledigit[k.charAt(0)-'0']);
      }
      if(len==2){
        if(k.charAt(0)-48==1){
           System.out.print(twodigits[k.charAt(1)-'0']);
         }
         else{
           System.out.print(tensmultiple[k.charAt(0)-'0']+" ");
           if(k.charAt(1)-'0'!=0){
             System.out.print(singledigit[k.charAt(1)-'0']+" ");
           }
         }
      }
  int i=0;
 if(len>2){
    while(len>2){
       if(k.charAt(i)-'0'!=0){
           System.out.print(singledigit[k.charAt(i)-'0']+" ");
           System.out.print(tenspower[len-3]+" ");
         }
         len--;
         i++;
}
        if(len==2){
        if(k.charAt(i)-48==0&&k.charAt(i+1)-48!=0){
           System.out.print(singledigit[k.charAt(i+1)-'0']);
        }
        if(k.charAt(i)-48==1){
           System.out.print(twodigits[k.charAt(i)-'0']);
         }
         else if(k.charAt(i)-48!=0){
           System.out.print(tensmultiple[k.charAt(i)-'0']+" ");
           if(k.charAt(i+1)-'0'!=0){
             System.out.print(singledigit[k.charAt(i+1)-'0']+" ");
           }
         }
      }
        
        
      }
      }
  }
