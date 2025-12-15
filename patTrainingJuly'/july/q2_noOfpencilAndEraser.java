package july;

    import java.util.*;
class q2_noOfpencilAndEraser
{
  public static int factorial(int n){
    if(n==0 ||  n==1){
      return 1;
    }else{
      return n*factorial(n-1);
    }
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int p = sc.nextInt();
    int e = sc.nextInt();
    
    System.out.println(factorial(n)/(factorial(p)*factorial(n-p)) * factorial(m)/(factorial(e)*factorial(m-e)));
  }
}

