package com.example.strings;


public class question20 {
    public static int countReversals(String s){
        if (s.length()%2!=0) return -1;
        int open = 0,close = 0,rev = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) =='{') open++;
            else {
                if (open==0) close++;
                else open--;
            }
        }
//        the logic is if we add the ceil in both the close and open

        rev = (int) (Math.ceil(open/2.0) + Math.ceil(close/2.0));
        return rev;
    }
    public static void main(String[] args) {
        System.out.println(countReversals("}{{}}{{{"));
    }
}
