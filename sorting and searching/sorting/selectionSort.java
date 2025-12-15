package com.example.sorting;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {7,9,1,2,5};

        printArray(arr);
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int smallest  = i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[smallest]>arr[j]) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }

        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
