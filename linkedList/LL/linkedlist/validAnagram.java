package com.example.linkedlist;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Handler;

public class validAnagram {
    public static boolean isAngram(String s,String t){
        HashMap<Character,Integer> map = new HashMap<>();
//        if (s.length()!=t.length()) return false;
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))==false){
                return false;
            }
            else if (map.get(t.charAt(i))== 1){
                map.remove(t.charAt(i));
            }else {
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
        }
        return map.size()==0;
    }

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        String s1 = ss.next();
        String s2 = ss.next();
        System.out.println(isAngram(s1,s2));

    }
}
