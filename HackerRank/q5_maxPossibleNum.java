
// You are given a non-negative integer num`. You will also be given an array `Digits of size exactly 10 where each element of the array 
// will be between 0-9 inclusive.
// You can perform the following operation on the given integer ‘num’ at most once.
// You can select a continuous part of ‘num’ and name it ‘x’. For each digit ‘D’ in the number ‘x’, you can change it to digits [D] 
// (consider 0-based indexing).
// You need to convert the given integer ‘num’ to a maximum possible number after performing the given operation at most once


// Input:
// 021 -> ‘num’
// 9435721906 -> Elements of Array ‘Digits’ (size of Array ‘digits’ is always 10 and Elements of the array are space separated)

// Output:
// 934

import java.util.*;
class q5_maxPossibleNum
{
  public static int[] maxPosNum(int num,int[] arr){
    String numStr = String.valueOf(num);
    char[] numCharArr = numStr.toCharArray();
    int[] ans = new int[numCharArr.length];

    for(int i=0;i<numCharArr.length;i++){
      int digit = numCharArr[i] - '0';
      if(arr[digit]>digit){
        ans[i] = arr[digit];
      }else{
        ans[i] = digit;
      }
    } 
    return ans;
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] arr = new int[10];
    for(int i=0;i<10;i++){
      arr[i] = sc.nextInt();
    }
    
    int[] ans = maxPosNum(num,arr);
    for(int i=0;i<ans.length;i++){
      System.out.print(ans[i]);
    }
  }
}
