package com.example.ARRAYS.arrays;

public class q6_rotateArraybyKElements {
    // brute force approach
    public static void rotateArrayByKBf(int[] arr,int n,int k ){
        if (n==0) return;
        // as k value can be greater than 7 that is ex  ;  if 8 then it can be divided into 7 + 1 , if 15 can be 7 + 7 + 1 
        // so we take the modulus of the number with n   ex:k%7;
        k  = k % 7;
        if (k==0)  return ;
        int[] karr = new int[k];
        // we will transfer the k no elements in the arr to the karr
        for(int i=0;i<k;i++){
            karr[i] = arr[i];
        }
        // now we will shift the remaining elements in arr to the position from which we have shifted the arrays to karr
        for(int i=0;i<n-k;i++){
            arr[i] = arr[i+k];
        }
        // we are putting back the elements in the karr to the positons which  we have shifted forward 
        for (int i = n - k; i < n; i++) {
            arr[i] = karr[i - n + k];
        }
    }
    // TC : O(N), as we are traversing the array only once
    // SC : O(k) ,since k array elements needs to be stored in temp array 

    // optimal approach
    // function to reverse the array
    public static void reverseArr(int[] arr,int start,int end){
        while (start<=end) {
           int  temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
        }
    }

    // function to rotate the array to the left 
    public static void rotateArrayOpt(int[] arr,int n,int k){
         // as k value can be greater than 7 that is ex  ;  if 8 then it can be divided into 7 + 1 , if 15 can be 7 + 7 + 1 
        // so we take the modulus of the number with n   ex:k%7;
        k = k%n;
        // first reverse the array by k elements
        reverseArr(arr, 0, k-1);

        // then reverse the array by n-k elements 
        reverseArr(arr, k, n-1);

        // now reverse the whole array
        reverseArr(arr, 0, n-1);
    }

    // TC : O(N)
    // SC : O(1)

    public static void main(String[] args){
        int[] arr =  {1,2,3,4,5,6,7};
        int n = 7;
        int k = 2;
        // rotateArrayByKBf(arr, n, k);
        rotateArrayOpt(arr, n, k);
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}