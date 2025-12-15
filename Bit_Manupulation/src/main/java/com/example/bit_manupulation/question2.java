package com.example.bit_manupulation;
//
//Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number
//        occur exactly once and are distinct. Find the other two numbers. Return in increasing order.
//
//
//        Example 1:
//        Input:
//        N = 2
//        arr[] = {1, 2, 3, 2, 1, 4}
//        Output:
//        3 4
//        Explanation:
//        3 and 4 occur exactly once.
//
//
//        Example 2:
//        Input:
//        N = 1
//        arr[] = {2, 1, 3, 2}
//        Output:
//        1 3
//        Explanation:
//        1 3 occur exactly once.
//
//
//        Expected Time Complexity: O(N)
//        Expected Space Complexity: O(1)

public class question2 {
    public static int[] singleNumber(int[] nums){
        int xor = 0;
        for (int i:nums){
            xor = xor^i;
        }
        int left = xor& -xor;
        int a=0,b=0;
        for (int x :nums){
            if ((x&left)==0){
                a=a^x;
            }else {
                b=b^x;
            }
        }
        if (a<b){
            return new int[]{a,b};
        }else {
            return new int[]{b,a};
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 2, 1, 4};
        System.out.println(question2.singleNumber(num));
    }
}
