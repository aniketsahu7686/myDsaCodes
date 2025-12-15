// Input format for testing:
// The candidate has to write the code to accept 2 inputs.
// First Input- Accept a string value consisting of only literal characters.
// Second Input-Accept a string value consisting of only characters.

// Output format for testing:
// The output should be string of characters which is same in both the input strings (check the output in Example 1 and 2)
// The output should be generated in alphabetic order sequence.

// Additional message in output cause the failure of test cases.

// Constraints:
// Str 1= {a-z}
// Str 2= {a-z}
// 0<size of str 1 <20
// 0< size of str 2 <20

// Example1:
// Input:
// beads -> value for str1
// leaps → value for str2
// Output:
// aes -> the key ‘aes’ is present in both strings


import java.util.*;
class q4_CombineLetter 
{
  public static String combLetter(String s1,String s2){
    int totalAlpha = 26;
    StringBuilder ans = new StringBuilder();
    
    int[] arr1 = new int[totalAlpha];
    int[] arr2 = new int[totalAlpha];
    
    for(int i=0;i<s1.length();i++){
      arr1[s1.charAt(i) - 'a'] += 1;
    }
    
    for(int i=0;i<s2.length();i++){
      arr2[s2.charAt(i) - 'a'] += 1;
    }
    
    
    for(int i=0;i<totalAlpha;i++){
      if(arr1[i]!=0 && arr2[i]!=0){
        for(int j=0;j<Math.min(arr1[i],arr2[i]);j++){
          ans.append((char)('a' + i));
        }
      }
    }
    
    return ans.toString();
  }
    
   public static void main(String args[])
  {
     Scanner sc = new Scanner(System.in);
     String s1 = sc.next();
     String s2 = sc.next();
     
     String ans = combLetter(s1,s2);
     System.out.println(ans);
  }
}


// TC : O(n)
// SC : O(1)