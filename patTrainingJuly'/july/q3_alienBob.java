package july;
import java.util.*;
class q3_alienBob
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int b = sc.nextInt();
    int n =sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i] = sc.nextInt();
    }
    for(int i=0;i<n;i++){
     b = b-(arr[i]%2 + arr[i]/2);
      if(b<0){
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
