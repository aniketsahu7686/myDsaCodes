package com.example.bit_manupulation;

//Divide two integers without using multiplication, division and mod operator
//
//        Example:
//
//        Input : a = 10, b = 3
//        Output : 3
//
//        Input : a = 43, b = -8
//        Output :  -5

public class question8 {
    public static long divide(long dividend ,long divisor){
        long sign = ((dividend<0)^(divisor<0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long quotient = 0,temp = 0;

        for (int i=31;i>=0;--i){
            if (temp + (divisor<<i) <= dividend){
                temp += divisor << i;
                quotient |= 1L <<i;
            }
        }
        if (sign==-1)
            quotient = -quotient;
        return quotient;
    }
    public static void main(String args[])
    {
        int a = 10, b = 3;
        System.out.println(divide(a, b));

        int a1 = 43, b1 = -8;
        System.out.println(divide(a1, b1));

    }
}
