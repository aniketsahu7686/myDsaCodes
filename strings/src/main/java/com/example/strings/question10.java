package com.example.strings;

public class question10 {
    public static String swap(String s,int a ,int b){
        char ch[] = s.toCharArray();
        char p = ch[a];
        ch[a] = ch[b];
        ch[b] = p;
        return String.valueOf(ch);
    }
    public static void permute(int index,String s){
        //base
        if (index==s.length()-1){
            System.out.println(s);
            return;
        }

        for (int i=index;i<s.length();i++){
            s = swap(s,i,index);
            permute(index+1,s);
            s = swap(s,i,index);
        }

    }
    public static void main(String[] args) {
        question10.permute(0,"ABC");
    }
}
