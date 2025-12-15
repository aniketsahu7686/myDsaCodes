package com.example.searchingandsorting;
//Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
//The Boyer-Moore voting algorithm is one of the popular optimal algorithms which is used to find the majority element among the given elements that have more than N/ 2 occurrences.
//        This works perfectly fine for finding the majority element which takes 2 traversals over the given elements, which works in O(N) time complexity and O(1) space complexity.
public class question8 {
    public static int findMajority(int[] nums){
        int count = 0,candidate = -1;
        for (int index = 0;index<nums.length;index++){
            if (count==0){
                candidate = nums[index];
                count = 1;
            }
            else {
                if (nums[index] == candidate)
                    count++;
                else
                    count--;
            }
        }

        count = 0;
        for (int index = 0;index<nums.length;index++){
            if (nums[index] == candidate)
                count++;
        }
        if (count>(nums.length/2))
            return candidate;
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 1, 2, 3, 4 };
        int majority = findMajority(arr);
        System.out.println(" The majority element is : "
                + majority);
    }
}
