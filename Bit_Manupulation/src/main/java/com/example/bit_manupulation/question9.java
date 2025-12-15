package com.example.bit_manupulation;
//Calculate square of a number without using *, / and pow()

//Examples :
//
//        Input: n = 5
//        Output: 25
//
//        Input: 7
//        Output: 49
//
//        Input: n = 12
//        Output: 144

public class question9 {
    public static int  squareWithoutdivmultpow(int n) {

        int ans = 0;
        if (n < 0) return -1;

        for (int i = 0; i < n; i++) {
            ans += n;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println( squareWithoutdivmultpow(5));
    }
}
