package com.example.strings;

//so here we will take four variables open , close , unbalanced  and swap
//        if we get an open bracket then open++ and if unbalanced is greater than 0 then add the unbalanced to the swaps and unbalanced-- it
//        or else if we get close bracket then close++ and we will found out the unbalnced = close-open
//        and finally return the swaps at last

public class question29 {
    public static int minimumNumberOfSwaps(String s){

        int open = 0 ,close = 0,swaps = 0,unbalanced = 0;
        for (int i=0;i<s.length();i++){

            if (s.charAt(i) == '[') {
                open++;
                if (unbalanced>0) {
                    swaps += unbalanced;
                    unbalanced--;
                }
            }
            else {
                close++;
                unbalanced = close-open;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumberOfSwaps("[]][]["));
    }
}

