package com.example.strings;

public class question11 {
    public static int splitSubstrings(String s){
        int x=0,y=0,c=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='0') x++;
            else y++;
            if (x==y) c++;
        }
        if (x!=y) {
            return -1;
        }
        return c;
    }
    public static void main(String[] args) {
        System.out.println(question11.splitSubstrings("0100110101"));
    }
}
