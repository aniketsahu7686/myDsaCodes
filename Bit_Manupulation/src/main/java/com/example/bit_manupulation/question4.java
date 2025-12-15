package com.example.bit_manupulation;


//Count total set bits
//
//
//        You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
//
//        Example 1:
//
//        Input: N = 4
//        Output: 5
//        Explanation:
//        For numbers from 1 to 4.
//        For 1: 0 0 1 = 1 set bits
//        For 2: 0 1 0 = 1 set bits
//        For 3: 0 1 1 = 2 set bits
//        For 4: 1 0 0 = 1 set bits
//        Therefore, the total set bits is 5.

//
//        Example 2:
//
//        Input: N = 17
//        Output: 35
//        Explanation: From numbers 1 to 17(both inclusive),
//        the total number of set bits is 35.


//Expected Time Complexity: O(log N).
//        Expected Auxiliary Space: O(1).


//so for solving this problem we use three sections of solutions :
//step 1 :
//use the formula 2power(n-1) *  x  for find the first sections of bits as it will follow the binary order
//
//step 2:
//for finding the last part that is 1 we use the formula  n- 2power(x) + 1
//
//step 3:
//we will use the recursion part to solve the repeated series

public class question4 {
    public static int countSetBits(int n){
        if (n==0) return 0;
        int x = powerof(n);
        int s1 = x*(int)Math.pow(2,(x-1));
        int s2 = (n-(int)Math.pow(2,x)) + 1;
        int ans = s1+s2 + countSetBits(n-(int)Math.pow(2,x));
        return ans;
    }
    public static int powerof(int n){
        int x= 0;
        while ((1<<x)<=n){
            x++;
        }
        return x-1;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(13));
    }

}
