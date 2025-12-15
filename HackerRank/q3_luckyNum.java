// face question 50

// You are given a string that contains a name hidden in it. Find the hidden name and try to find the Lucky number for it.
// (Find the alpha characters and find the sum of alphabetical values. The lucky number is the digital sum reduced up to a single digit.)
// Sample Input 1:
// D@h*o1n&i%
// Sample Output 1:
// 5


import java.util.*;
class q3_luckyNum
{
  public static int luckyNum(String s){
    int n = s.length();
    int sum = 0;
    for(int i=0;i<n;i++){
      char sub = s.charAt(i);
      if(Character.isLowerCase(sub)){
        sum += (sub - 'a' + 1);
      }else if(Character.isUpperCase(sub)){
        sum += (sub - 'A' + 1);
      }
    }
    
    if(sum>9){
      sum = sum%9;
    }else{
      sum = sum;
    }
    return sum;
  }
  public static void main(String args[])
  {
    //Try out your code here
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    
    int ans = luckyNum(s);
    System.out.println(ans);
  }
}
