package com.example.strings;
//
//Palindrome String
//
//Given a string S, check if it is palindrome or not
//
//        Example 1:
//        Input: S = "abba"
//        Output: 1
//        Explanation: S is a palindrome
//
//
//        Example 2:
//        Input: S = "abc"
//        Output: 0
//        Explanation: S is not a palindrome


public class question2 {
    public static int palindromeStrings(String s){
        int start = 0;
        int end = s.length()-1;
        while (start<end){
            if (s.charAt(start++) !=  s.charAt(end--)){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(palindromeStrings("aniket"));
    }
}
