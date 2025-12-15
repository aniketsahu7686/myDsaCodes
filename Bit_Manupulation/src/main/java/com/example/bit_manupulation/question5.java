package com.example.bit_manupulation;

//Power of 2
//
//Win Prize worth ₹6000 with Ease. Register for the Easiest Coding Challenge!
//
//        Given a non-negative integer N. The task is to check if N is a power of 2. More formally, check if N can be expressed as 2x for some x.
//
//        Example 1:
//
//        Input: N = 1
//        Output: YES
//        Explanation:1 is equal to 2
//        raised to 0 (20 = 1).
//        Example 2:
//
//        Input: N = 98
//        Output: NO
//        Explanation: 98 cannot be obtained
//        by any power of 2.
//
//
//Expected Time Complexity:O(log N).
//        Expected Auxiliary Space:O(1).

//ans:

//the logic is if keep the n and n-1 and use the & operator in this
//if we get 0 then it is ans of power of 2    (n&(n-1)==0)
public class question5 {
    public static boolean powerOf2(int n){
        int val = (n& (n-1));
        if (n==0){
           return false;
        }
        else if (val==0){
           return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(powerOf2(19));
    }
}
