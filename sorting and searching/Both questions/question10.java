package com.example.searchingandsorting;

import java.util.Arrays;
//Find Pair Given Difference

//Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N
//
//Example 1:
//
//        Input:
//        L = 6, N = 78
//        arr[] = {5, 20, 3, 2, 5, 80}
//        Output: 1
//        Explanation: (2, 80) have difference of 78.
//
//        Example 2:
//
//        Input:
//        L = 5, N = 45
//        arr[] = {90, 70, 20, 80, 50}
//        Output: -1
//        Explanation: There is no pair with difference of 45.
//
//        Expected Time Complexity: O(L* Log(L)).
//        Expected Auxiliary Space: O(1).
public class question10 {
    public static void findPair(int[] arr, int n, int target){
        Arrays.sort(arr);
        int i=0;
        int j=1;
        while (i<arr.length && j<arr.length){
            if (arr[j]-arr[i]==target){
                System.out.println(arr[i] + " " + arr[j]);
                return;
            }
            else if ((arr[j]-arr[i])<target){
                j++;
            }
            else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int  arr[] = {5, 20, 3, 2, 5, 80};
        question10.findPair(arr,6,78);

    }
}
