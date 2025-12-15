package com.example.searchingandsorting;
//Product array puzzle
//
//        Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i].
//
//
//
//        Example 1:
//        Input:
//        n = 5
//        nums[] = {10, 3, 5, 6, 2}
//        Output:
//        180 600 360 300 900
//        Explanation:
//        For i=0, P[i] = 3*5*6*2 = 180.
//        For i=1, P[i] = 10*5*6*2 = 600.
//        For i=2, P[i] = 10*3*6*2 = 360.
//        For i=3, P[i] = 10*3*5*2 = 300.
//        For i=4, P[i] = 10*3*5*6 = 900.
//
//
//
//
//        Example 2:
//        Input:
//        n = 2
//        nums[] = {12,0}
//        Output:
//        0 12
public class question16 {
    public static long[] productArray(int arr[],int n){
        long[] left = new long[n];
        long[] right = new long[n];
        long[] ans = new long[n];

        left[0] = 1;
        right[n-2] = 1;

        for (int i=1;i<n;i++){
            left[i] = left[i-1]*arr[i-1];
        }
        for (int i=n-2;i>0;i--){
            right[i] = right[i+1]*arr[i+1];
        }
        for (int i=0;i<n;i++){
            ans[i] = left[i]*right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int  arr[] = {10, 3, 5, 6, 2};
        System.out.println(question16.productArray(arr,5));

    }
}