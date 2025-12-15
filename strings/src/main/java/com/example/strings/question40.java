package com.example.strings;

public class question40 {
    public static int transformString(String s1,String s2){
        int str1 = s1.length() ,str2 = s2.length(), m=0,n=0,c=0;
        if (str1!=str2) return -1;
        for (int i=0;i<str1;i++){
            m += s1.charAt(i);
        }
        for (int i=0;i<str2;i++){
            n += s1.charAt(i);
        }
        if (m!=n) return -1;

        int x = str1-1,y = str2-1;
        while (x>=0 && y>=0){
            if (s1.charAt(x)==s2.charAt(y)){
                y--;
                x--;
            }else {
                c++;
                x--;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        System.out.println(transformString("EACBD","EABCD"));
    }
}
