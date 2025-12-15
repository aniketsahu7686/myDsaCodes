package com.example.bit_manupulation;
//Number of 1 Bits

//Given a positive integer N, print count of set bits in it.
//
//        Example 1:
//
//        Input:
//        N = 6
//        Output:
//        2
//        Explanation:
//        Binary representation is '110'
//        So the count of the set bit is 2.
//
//
//
//        Example 2:
//
//        Input:
//        8
//        Output:
//        1
//        Explanation:
//        Binary representation is '1000'
//        So the count of the set bit is 1

//we can do it by making the numbers such 3:11 and & it with 01  so 1&1 is 1  and 1&0 is 0
//and then left shift by one digite


//or we can do it by dividing with 2 and by using the reaminder



//Expected Time Complexity: O(LogN)
//        Expected Auxiliary Space: O(1)d

public class question1 {
    public static int No_1Bits(int N){
        int bit = 0;
        int count = 0;
        while (N>0){
            bit = N%2;
            if (bit==1) {
                count++;
            }
            N=N/2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(question1.No_1Bits(5));
    }
}
