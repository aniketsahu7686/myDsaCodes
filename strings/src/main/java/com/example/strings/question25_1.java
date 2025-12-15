package com.example.strings;

//integer to roman


//requirements understanding for this question
//I   V   X   L    C       D      M
//1   5   10  50  100     500    1000
//
//X-I = IV = 4
//X-I = IX = 9
//
//L-X = XL = 40
//C-X = XC = 90
//
//D-C = CD = 400
//M-C = CM = 900


//M - 1000
//CM - 900
//D - 500
//CD - 400
//C - 100
//XC - 90
//L - 50
//XL - 40
//X - 10
//IX - 9
//V - 5
//IV - 4
//I - 1

//ex : if 283 then we have to subtract the upper no so that it will convert to


public class question25_1 {
    public static String intToRoman(int num){
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();

        for (int i=values.length-1;i>=0 && num>0 ;i--){
            while (num>= values[i]){
                num-=values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(500));
    }
}
