// Ria likes to play a number game always. Today she decided to find the largest number that can be made using all of the digits of 
// the given input(Non negative integer) value N.

// Example 1:
// Input :
// 3675092 -> value of N

// Output:
// 9765320

import java.util.*;
class q6_reverseLargerNum
{
  public static int[] largestNum(int num){
    String numStr = String.valueOf(num);
    int n = numStr.length();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        // Subtracting the Unicode value of '0' from any digit character will give the integer value of that character.
        //  For example, the Unicode value of '1' is 49, and '0' is 48, so '1' - '0' is 49 - 48 which equals 1.
      arr[i] = numStr.charAt(i) - '0' ;
    }
    
    Arrays.sort(arr);
    return arr;
  }
  public static void main(String args[])
  {
   Scanner sc = new Scanner(System.in);
   int num = sc.nextInt();
    int [] ans = largestNum(num);
    int n = ans.length;
    for(int i=n-1;i>=0;i--){
      System.out.print(ans[i]);
    }
    
  }
}