package com.example.searchingandsorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class question18 {
    public static int minSwaps(int nums[]){
        int ans=0;
        int n = nums.length;
        int[] temp = Arrays.copyOfRange(nums,0,n);

        HashMap<Integer,Integer>  h = new HashMap<Integer,Integer>();

        Arrays.sort(temp);
        for (int i=0;i<n;i++){
            h.put(nums[i],i);
        }
        for (int i=0;i<n;i++){
            if (nums[i]!=temp[i])
                ans++;
            int init = nums[i];
            int j = h.get(temp[i]);
            int tp = nums[i];
            nums[i] = nums[j];
            nums[j] = tp;
            h.put(init,h.get(temp[i]));
            h.put(temp[i],i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {18,19,6,3,5};
        System.out.println(question18.minSwaps(arr));
    }
}
