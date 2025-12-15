package com.example.strings;

// Reverse String
//Write a function that reverses a string. The input string is given as an array of characters s.
//        You must do this by modifying the input array in-place with O(1) extra memory.

//
//Example 1:
//
//        Input: s = ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
//        Example 2:
//
//        Input: s = ["H","a","n","n","a","h"]
//        Output: ["h","a","n","n","a","H"]

public class question1 {
    public static void reverseStrings(char[] arr){
        int left = 0;
        int right = arr.length;
        while (left<arr.length){
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = arr[left];
        }
    }

    public static void main(String[] args) {
//         arr = new  ["h","e","l","l","o"];
//        reverseStrings(arr);
    }
}
