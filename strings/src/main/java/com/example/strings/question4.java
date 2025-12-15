package com.example.strings;
//Check if given strings are rotations of each other or not
//
//solution;
//This is an optimize solution known as Knuth–Morris–Pratt algorithm as it  Follow the given steps to solve the problem
//        Create a temp string and store concatenation of str1 to str1 in temp, i.e temp = str1.str1
//        If str2 is a substring of temp then str1 and str2 are rotations of each other.
//
//        Example:
//        str1 = “ABACD”, str2 = “CDABA”
//        temp = str1.str1 = “ABACDABACD”
//        Since str2 is a substring of temp, str1 and str2 are rotations of each other.

//time complexity : O(n);
//space complexity: O(n);

public class question4 {
    public static boolean findStringRotation(String mssge1,String mssge2){
      return (mssge1.length()==mssge2.length()) && ((mssge1+mssge1).indexOf(mssge2) !=-1);
    }
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "cdba";

        if (findStringRotation(str1,str2)){
            System.out.println("Strings are rotations of each other");
        }else {
            System.out.println("Strings are not roatations of each other");
        }
    }
}
