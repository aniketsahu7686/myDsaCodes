package com.example.bit_manupulation;

//solution:
//step 1: calculate xor of A and B.
//       a_xor_b = A^B
//step 2 : Count the set bits in the above calculated XOR result.
//       countSetBits(a_xor_b)


//Bit Difference
//
//
//You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.
//
//        Example 1:
//
//        Input: A = 10, B = 20
//        Output: 4
//        Explanation:
//        A  = 01010
//        B  = 10100
//        As we can see, the bits of A that need
//        to be flipped are 01010. If we flip
//        these bits, we get 10100, which is B.
//
//
//        Example 2:
//
//        Input: A = 20, B = 25
//        Output: 3
//        Explanation:
//        A  = 10100
//        B  = 11001
//        As we can see, the bits of A that need
//        to be flipped are 10100. If we flip
//        these bits, we get 11001, which is B

public class question3 {
    public  int bitDifference(int a,int b){
        int xor =  a^b;
        int c= 0;

        while (xor>0){
            if ((xor%2)==1){
                c++;
                xor = xor/2;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        question3 s = new question3();
        s.bitDifference(10,20);
    }
}
