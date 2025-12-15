package com.example.strings;

//from left to right it is a prefix and from right to left it is sufix

//process1  :   we have to compare all the strings and see the longest common prefix
//
// dowt in this approach
//    public static String longestCommonPrefix(String[] strs ){
//        if (strs.length==0) return " ";
//        String prefix = strs[0];
//        for (int i=1;i<strs.length;i++){
//            while (strs[i].indexOf(prefix)!=0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return " ";
//            }
//        }
//        return prefix;
//    }
//process2 : we put the strings in trie and if the parent node contain more than one child element then we will come back and the longest string from is from the last parent node
//


import java.util.Arrays;
import java.util.Locale;

//process 3 : using sorting
public class question26 {
    public static String longestCommonPrefix(String[] strs ){
        StringBuilder result = new StringBuilder();

//        sort the array
        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

//        start comaparing
        for (int i=0;i<first.length;i++){
            if (first[i]!=last[i]) break;
            result.append(first[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
