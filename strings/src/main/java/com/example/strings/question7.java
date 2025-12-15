package com.example.strings;

public class question7 {
    public  String longestPalindrome(String s){
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
            int len1 = expandFromCentre(s,i,i+1);
            int len2 = expandFromCentre(s,i,i);
            int len = Math.max(len1,len2);
            if (end-start<len){
                start = i-(len-1)/2;
                end  = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    int expandFromCentre(String s,int i,int j){
        while (i>0 && j<s.length()-1 && s.charAt(i--)==s.charAt(j++));
        return j-i+1;
    }
    public static void main(String[] args) {
        question7 ss = new question7();
        System.out.println(ss.longestPalindrome("aaaabbaa"));
    }
}
