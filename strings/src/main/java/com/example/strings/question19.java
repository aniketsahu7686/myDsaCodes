package com.example.strings;

//ASCII stands for (American Standard Code for Information Interchange), It is a standard data-encoding format for computer-to-computer communication. ASCII assigns numeric values to letters,
//        numerals, punctuation marks, and other computer characters. The ASCII values of the alphabet for the lowercase are from 97 to 122. And, the ASCII values of the alphabet for the
//        uppercase alphabet from 65 to 90. If the ASCII value of the character entered by the user lies in the range of 97 to 122 or from 65 to 90, that number is an alphabet.
//        In this section, we will discuss the ASCII code of a to z for lowercase and uppercase

public class question19 {
    public static String  findMobilePadSeq(String sentence){
        String output = " ";
        String arr[]  = {"2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999"};
        for (int i=0;i<sentence.length();i++){
            if (sentence.charAt(i) == ' ') {
                output+="0";
            }else {
                output+=arr[sentence.charAt(i)-'A'];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String sentence = "SHASWATTIWARI";
        System.out.println(findMobilePadSeq(sentence));
    }
}