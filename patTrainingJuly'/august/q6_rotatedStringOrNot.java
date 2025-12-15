package august;

// Given two strings str1 and str2, find if str1 is the rotated version of str2 then print “Yes”.
// Otherwise, print “No”.


// Constraints:
// Str1<20
// Str2<20

// Sample input:
// abcd
// dabc

// Sample output:
// Yes

import java.util.*;
class q6_rotatedStringOrNot 
{
  public static String rotatedVersion(String str1,String str2)
  {
    if(str1.length()!=str2.length() || str1.isEmpty() || str2.isEmpty())
    {
      return "No";
    }
    String str = str2+str2;
    
    if(str.contains(str1)){
      return "Yes";
    }
       
    return "No";
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    String a1 = sc.next();
    String a2 = sc.next();
    
    String ans = rotatedVersion(a1,a2);
    System.out.println(ans);
  }
}
