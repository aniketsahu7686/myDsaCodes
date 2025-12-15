package com.example.searchingandsorting;
//Consider a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on. You are given a number N, you have to output the number of integers
//        less than N in the sample space S.\

//Difference in Ceiling value and floor value
//The ceiling function returns the smallest nearest integer which is greater than or equal to the specified number whereas the floor function returns the largest nearest
//        integer which is less than or equal to a specified value.

public class question4 {
    static int countSquares(int N){
        double a = Math.sqrt(N);
        int n = (int)Math.ceil(a);
        return n-1;
    }

    public static void main(String[] args) {
//        question4 ss  = new question4();
//        System.out.println(ss.countSquares(9));
        System.out.println( question4.countSquares(9));
    }
}
