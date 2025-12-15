package com.example.strings;

import java.util.Stack;

public class question15 {
    public static boolean ispar(String x){
        Stack<Character> st = new Stack<>();
        for (int i=0;i<x.length();i++){
            if (x.charAt(i)=='[' || x.charAt(i)=='{' || x.charAt(i)=='('){
                st.push(x.charAt(i));
            }else {
                if (st.isEmpty()){
                    return false;
                }else if (! isMatching(st.peek(),x.charAt(i))){
                    return false;
                }else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
    static boolean isMatching(char a,char b){
        return (a=='{' && b=='}') ||
                (a=='[' && b == ']') ||
                (a=='(' && b==')');
    }

    public static void main(String[] args) {
        System.out.println(question15.ispar("{([])}"));
    }
}
