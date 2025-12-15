//  package com.example.sorting;  

public class insertionSort {

    public static void printArray(int[] arr){

        //insertion sort
        // first we will run the loop upto the unsorted array
        for (int i=1;i<arr.length;i++){
            // this is the element which we have to pick up and put it in the right place
            int current = arr[i];
            int j = i-1;
            // here to track the sorted part we are using the j (condition is that it should be greater than or equal to 0),
            // 
            while(j>=0 && current<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }

            //placement(when we have compare all the indexes or not element is left)
            arr[j+1] = current;
        }

         for (int i=0;i<arr.length;i++){
             System.out.print(arr[i] + " ");
         }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {7,9,1,2,8};

        printArray(arr);
        

    }
}
