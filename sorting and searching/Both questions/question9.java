package com.example.searchingandsorting;
//Searching in an array where adjacent differ by at most k

public class question9 {
    public static int search(int[] arr,int n,int k,int x){
        int index = 0;
        while(index<n){
            if (arr[index] == x) return index;
            int steps = Math.abs((arr[index]-x)/k);
            index = index+Math.max(1,steps);
        }
        return -1;
    }

    public static void main(String[] args) {
       int  arr[] = {4, 5, 6, 7, 6};
        System.out.println(question9.search(arr,5,1,6));
    }
}
