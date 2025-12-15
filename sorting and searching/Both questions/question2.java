package com.example.searchingandsorting;
//1-based numbering is the computational idea of indexing an ordered data structure (e.g., a string or array) by starting with 1 instead of 0.
//        For example, if is the string "ACGT", then is given by the symbol 'A' and is 'C'.

import java.util.ArrayList;

//Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of its index value ( Consider 1-based indexing ).
public class question2 {
    ArrayList<Integer> valueEqualToIndex(int arr[],int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            int val = arr[i];
            int requin = i+1;
            if (val == requin){
                list.add(val);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        question2 ss = new question2();
        int arr[] = {15, 2, 45, 12, 7};
        System.out.println(ss.valueEqualToIndex(arr,5));
    }
}
