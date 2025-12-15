import java.sql.Time;

public class q16_palindromeOrNot {
    // 1st approach
    // The idea is to find the reverse of the original number and then compare the reversed number with the original number.
    // If the reversed number is same as the original number, the number is Palindrome. Otherwise, the number is not a Palindrome.
     public static boolean palindromeOrNotApp1(int n){
        // if there is a negative no then , definately it is not a palindrome no . Ex -121 when reverse it will be 121-
        if (n<0) {
            return false;
        }
        int reverse = 0;
        int temp = n;

        while (temp!=0) {
            reverse = (reverse*10) + (temp%10);
            temp = temp/10;
        }

        return reverse==n;
     }

     // Time Complexity : O(log10(N)) or O(Number of digits in a given number)
    //  Auxiliary space : O(1) or constant

    // 2nd approach
    // can be done using the strings
    public static boolean palindromeOrNotApp2(int n){
        if (n<0) {
            return false;
        }
        String newN = Integer.toString(n);
        int length = newN.length();

        for(int i=0;i<n/2;i++){
            if (newN.charAt(i)!=newN.charAt(length-i-1)) {
                return false;
            }
        }
        return true;
    }

    // Time Complexity: O(|str|) or O(number of digits)
    // Auxiliary Space: O(1) 
    
    
    public static void main(String[] args) {
        int n = -121;
        // boolean ans = palindromeOrNotApp1(n);
        boolean ans = palindromeOrNotApp2(n);

        if (ans==true) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}