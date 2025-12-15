package com.example.strings;

import java.util.HashMap;

public class question41 {
    public static boolean isoMorphic(String s1,String s2){
        if (s1.length()!=s2.length()) return false;

        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Boolean> map2 = new HashMap<>();

        int ismMorp = 0;
        for (int i=0;i< s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (map1.containsKey(ch1)==true){
                if (map1.get(ch1)!=(ch2)){
                    return false;
                }
            }else{
                if (map2.containsKey(ch2)==true){
                    return false;
                }else {
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                    ismMorp++;
                }
            }
        }
        return true ;
    }
    public static void main(String[] args) {
        System.out.println(isoMorphic("aab","xxy"));
    }
}
