package com.example.strings;

public class palindromeOrNot {
    public static Boolean palindromeornot(String string){
        char[] res = string.toCharArray();
        int start =0,end = string.length()-1;
        for (int i=0;i<string.length()-1;i++){
            while (start++<end--){
                if (res[start]!=res[end]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(palindromeOrNot.palindromeornot("aaba"));
    }
}
