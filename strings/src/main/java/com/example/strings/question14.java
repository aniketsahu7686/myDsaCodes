package com.example.strings;

public class question14 {

//    step 1 : Find first decreasing sequence starting from end

    public  void nextPermutation(int[] nums){
        int i = nums.length - 2;
        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if (i>=0){
            int j = nums.length-1;
            while (j>=0 && nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
         reverse(nums,i+1);
    }


//    step 2 : Find the number for substitution and perform swap

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    step 3: Rearrange remaining array by reversing it
    public void reverse(int[] nums,int start){
        int end = nums.length-1;
        while (start<end){
            swap(nums,start++,end--);
        }
    }
    public static void main(String[] args) {
        question14 ss =new question14();
        int[] nums = {4,1,7,5,3,2,0};
        ss.nextPermutation(nums);
    }
}
