package com.example.bit_manupulation;


//time complexity = O(logN)

public class decimalToBinary {
    public static void decToBin(int n){
        int[] binaryNo = new int[32];

        int i=0;
        while (n>0){
            binaryNo[i] = n%2;
            n=n/2;
            i++;
        }
        for (int j=i-1;j>=0;j--){
            System.out.print(binaryNo[j]);
        }
    }

    public static void main(String[] args) {
        decimalToBinary.decToBin(17);

    }

}
