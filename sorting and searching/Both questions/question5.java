package com.example.searchingandsorting;

import java.lang.reflect.Array;
import java.util.Arrays;

//Given three distinct numbers A, B and C. Find the number with value in middle (Try to do it with minimum comparisons).
public class question5 {
    static  int middle(int a ,int b,int c){
        int arr[] = {a,b,c};
        Arrays.sort(arr);
        return arr[1];
    }

    public static void main(String[] args) {
        System.out.println(question5.middle(589,854,368));
    }

}
