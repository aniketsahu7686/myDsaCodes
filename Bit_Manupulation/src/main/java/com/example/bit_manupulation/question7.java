package com.example.bit_manupulation;

//Copy set bits in a range
//
//Given two numbers x and y, and a range [l, r] where 1 <= l, r <= 32. The task is consider set bits of y in range [l, r] and set these bits in x also.
//        Examples :
//
//        Input  : x = 10, y = 13, l = 2, r = 3
//        Output : x = 14
//        Binary representation of 10 is 1010 and
//        that of y is 1101. There is one set bit
//        in y at 3'rd position (in given range).
//        After we copy this bit to x, x becomes 1110
//        which is binary representation of 14.
//
//        Input  : x = 8, y = 7, l = 1, r = 2
//        Output : x = 11


//there are two steps to solve this problem:
//
//step 1:  checking kth bit
//        n
//        1<<k-1;
//        n&(1<<k-1)
//
//step 2:   setting kth bit
//
//       n
//       1<<k-1;
//        n|(1<<k-1)

public class question7 {
    public static int copySetBits(int x,int y,int l, int r){
        if (l<1 || r>32){
            return x;
        }
        for (int i=l;i<=r;i++){

            int kthbit = 1<<(i-1);
            if ((y & kthbit)!=0){
                x = x | kthbit;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(copySetBits(10,13,2,3));
    }
}
