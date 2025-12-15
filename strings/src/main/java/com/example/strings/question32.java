package com.example.strings;

//distinct elements means different elements

import java.util.HashSet;

//first we will find the distinct elements by inserting all the strings in a hashset
//and we have to create a visited array so that the smallest sustring window store in it bu using ASCII property

public class question32 {
    public  static  String findSubString(String str){

        HashSet<Character> set = new HashSet<Character>();

        for (int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }

        int distCount = set.size();
        int start = 0,startIndex = 0,min_len = Integer.MAX_VALUE;
        int counter = 0;
        int visited[] = new int[256];
        for (int i=0;i<str.length();i++){

            visited[str.charAt(i)-65]++;

            if (visited[str.charAt(i)-65]==1) counter++;

            if (counter==distCount){
                while (visited[str.charAt(start)-65]>1){
                        if (visited[str.charAt(start)-65]>1) visited[str.charAt(start)-65]--;
                        start++;
                }
                int cur_len = i-start+1;
                if (cur_len<min_len){
                    min_len =cur_len;
                    startIndex= start;
                }
            }

        }
        return str.substring(startIndex,startIndex+min_len);
    }
    public static void main(String[] args) {
        System.out.println(findSubString("AABBBCBBAC"));
    }
}
