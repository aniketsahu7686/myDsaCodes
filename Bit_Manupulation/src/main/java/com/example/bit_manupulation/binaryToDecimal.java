package com.example.bit_manupulation;

public class binaryToDecimal {
     public static int binToDec(int n) {
        int num = n;
        int dec_value = 0;
        int base = 1;
        int temp = num;
        while (temp > 0) {
            int last_digit = temp % 10;
            dec_value += last_digit * 1;
            base = base * 2;
        }
        return dec_value;
    }

    public static void main(String[] args) {
         int num = 10001;
        System.out.println( binToDec(num));
    }
}
