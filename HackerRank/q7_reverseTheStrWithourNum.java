// Given a string Str, which contains numbers (0 to 9)and also letters of the English and to 'Z'). The task is to reverse string 
// the string in such a way that the positiors of numbers in the string are left unaltered.

// Example 1:
// Input:
// a1b2igh3 -> Value of Str

// Output:
// h1g2iba3

import java.util.*;
class q7_reverseTheStrWithourNum 
{
  public static String reverseStr(String str){
    char[] charArr = str.toCharArray();
    int left=0 , right = charArr.length-1;
    while(left<right){
       if(Character.isDigit(charArr[left])){
         left++;
       }
      else if(Character.isDigit(charArr[right])){
        right--;
      }else{
         char temp = charArr[left];
         charArr[left] = charArr[right];
         charArr[right] = temp;
         left++;
         right--;
      }
    }
    // Use new String(charArr): When you need to convert a char array to a String that represents the characters in the array.
    // Avoid charArr.toString(): As it does not provide the actual character sequence but rather a default object representation
    return new String(charArr);
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    
    String str = sc.next();
    
    String  ans = reverseStr(str);
    
    System.out.println(ans);
    
  }
}