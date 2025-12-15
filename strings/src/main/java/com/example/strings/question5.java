package com.example.strings;
import java.util.*;

//Java Program to Check if a string is a valid shuffle of two distinct strings

public class question5 {
    public static boolean isShuffled(String s1,String s2,String res){
        int n = s1.length();
        int m = s2.length();
        if (n + m != res.length()){
            return false;
        }

        s1 = sort(s1);
        s2 = sort(s2);
        res = sort(res);

        int i = 0,j=0,k=0;
        while (k<res.length()){
            if (i<n && s1.charAt(i) == res.charAt(k)) i++;
            else if (j<m && s2.charAt(j)==res.charAt(k)) j++;
            else return false;
            k++;
        }
        return i>=n && j>=0;
    }
    public static String sort(String ss){
        char[]  ca = ss.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "ani";
        String s3 = "a12in3";
        if (isShuffled(s1,s2,s3)){
            System.out.println("yes");
        }
        else {
            System.out.println("No");
        }

    }
}
