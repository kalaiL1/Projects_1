import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    in.nextLine();
    int a[]=new int[n];
    String[] inputs = in.nextLine().split(" ");
    for(int i = 0; i < n; i++) {
    a[i] = Integer.parseInt(inputs[i]);
     }
    int m=ascb(Arrays.copyOf(a,n),n);
    int o=descb(Arrays.copyOf(a,n),n);
    System.out.print("min swaps req: "+Math.min(m,o));
    
  }
  static int ascb(int a[],int n){
    int sc=0;
    boolean sw;
    for(int i=0;i<=n-1;i++){
      sw=false;
      for(int j=0;j<=n-2-i;j++){
        if(a[j]>a[j+1]){
          sc++;
          int t=a[j];
          a[j]=a[j+1];
          a[j+1]=t;
          sw=true;
        }
      }
      if(sw==false)break;
    }
    return sc;
  }
  static int descb(int a[],int n){
    int sc=0;
    boolean sw;
    for(int i=0;i<=n-1;i++){
      sw=false;
      for(int j=0;j<=n-2-i;j++){
        if(a[j]<a[j+1]){
          sc++;
          int t=a[j];
          a[j]=a[j+1];
          a[j+1]=t;
          sw=true;
        }
      }
      if(sw==false)break;
    }
    return sc;
  }
}