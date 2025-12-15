package july;

import java.util.*;

class q1_noOfConversion 
{
  public static int noOfConversion(String str1,String str2,int n){
    HashMap<Character,Integer> hp = new HashMap<>();
    for(int i=0;i<n;i++){
      hp.put(str1.charAt(i),i);
    }
    for(int i=0;i<n;i++){
      if(!hp.containsKey(str2.charAt(i))){
        return -1;
      }
    }
    int c = 0;
    for(int i=0;i<n;i++){
      if(str1.charAt(i)!=str2.charAt(i)){
        c++;
      }
    }
    return c;
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str1 = sc.next();
    String str2 = sc.next();
    
    int ans = noOfConversion(str1,str2,n);
    System.out.println(ans);
  }
}