package com.example.strings;

//brute force approach:
//
//first we will traverse the strings values and compare one bye one and then store the keys and its values in by creating two arrays .
//The main disadvantage of this is that it works on O(n2) time complexity and also O(n) space complexity

//
//optimal approach :
//by using maps

import java.util.HashMap;
import java.util.Map;

public class question28 {
//    public static String secFrequent(String arr[] ,int n){
//        HashMap<String,Integer> map = new HashMap<>();
//        for (int i=0;i<arr.length;i++){
//            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
//        }
//        int firstMax = Integer.MIN_VALUE ,secMax = Integer.MIN_VALUE;
//        for (Map.Entry mapElements : map.entrySet()){
//            int key = mapElements.getKey();
//            int value = map.Elements.getValue();
//            if (value>firstMax){
//                secMax  = firstMax;
//                firstMax = value;
//            }else if (value.secMax && value<firstMax){
//                secMax = value;
//            }
//        }
//        for (Map.Entry mapElements : map.entrySet()){
//            key = (String)mapElements.getKey();
//            value = (int)mapElements.getValue();
//            if (value==secMax ) return key;
//        }
//        return null;
//    }
}
