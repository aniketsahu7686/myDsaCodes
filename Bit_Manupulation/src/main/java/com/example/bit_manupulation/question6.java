package com.example.bit_manupulation;


//Find position of set bit
//
//Given a number N having only one ‘1’ and all other ’0’s in its binary representation, find position of the only set bit.
// If there are 0 or more than 1 set bit the answer should be -1.
//        Position of  set bit '1' should be counted starting with 1 from LSB side in binary representation of the number.
//
//        Example 1:
//        Input:
//        N = 2
//        Output:
//        2
//        Explanation:
//        2 is represented as "10" in Binary.
//        As we see there's only one set bit
//        and it's in Position 2 and thus the
//        Output 2.
//
//
//        Example 2:
//        Input:
//        N = 5
//        Output:
//        -1
//        Explanation:
//        5 is represented as "101" in Binary.
//        As we see there's two set bits
//        and thus the Output -1.
//
//
//Expected Time Complexity: O(log(N))
//        Expected Auxiliary Space: O(1)

public class question6 {
    public static double positonOfSetBit(int n){
        if (n==0) return -1;
        if ((n & (n-1)) == 0){
            int c = 0;
            while(n!=0){
                c++;                          // Method 1 : by right shifting the digits left side
                n = n>>1;
            }
//           Method 2:    The logarithmic identity logba = log10(a)/log10(b) is commonly used to derive log2 for a number x. i.e. log2x = log10(x)/log10(2)
            //double c = Math.log(n)/Math.log(2) + 1;

            return c;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(positonOfSetBit(5));
    }
}
