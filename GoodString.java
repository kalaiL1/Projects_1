import java.util.*;

public class GoodString {
    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    String gstring=in.nextLine();
    String name=in.next();
    int asciiv[]=new int[gstring.length()];
    for(int i=0;i<gstring.length();i++){
      asciiv[i]=(int)gstring.charAt(i);
    }
    HashSet<Integer> check = new HashSet<>();
        for (int value : asciiv) {
            check.add(value);
        }
    int sum=0;
    int prgood=asciiv[0]; 
      for(int i=0;i<name.length();i++){
          int currentch=(int)name.charAt(i);
         if(check.contains(currentch)){
            continue;
          }
          int pg=prgood;
          int min=Integer.MAX_VALUE;
        for(int j=0;j<asciiv.length;j++){
          int q=Math.abs(currentch-asciiv[j]);
          if(q<min){
            min=q;
            pg=asciiv[j];
          }
          else if(q==min){
               int x=Math.abs(prgood-pg);
               int y=Math.abs(prgood-asciiv[j]);
               if(y<x){
                   pg=asciiv[j];
                   
               }
               min=Math.abs(prgood-pg);
               break;
              }
             
          }
   
          sum+=min;
          prgood=pg;
          
        }
        
        System.out.print(sum); 
    }
   
    
  }