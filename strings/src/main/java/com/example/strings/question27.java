package com.example.strings;


//"001"  -->  101  --> 1
//            010  --> 2
//ans should be min of these two
//
//so "101" -->  1
//total len - 1 = 2
//3-1 = 2
//
//so in even index = 1;
//odd index = 0;


public class question27 {
    public static int minFlips(String s){
        int flips = 0;
        for (int i=0;i<s.length();i++){
            if (i%2==0){
                if (s.charAt(i) == '0') flips++;
            }
            else if (i%2!=0){
                if (s.charAt(i) == '1') flips++;
            }
        }
        return Math.min(flips,s.length()-flips);
    }
    public static void main(String[] args) {
        System.out.println(minFlips("0001010111"));
    }
}
