package com.example.strings;
//Examples:
//        Input:  txt[] = “THIS IS A TEST TEXT”, pat[] = “TEST”
//        Output: Pattern found at index 10
//
//        Input:  txt[] =  “AABAACAADAABAABA”, pat[] =  “AABA”
//        Output: Pattern found at index 0
//        Pattern found at index 9
//        Pattern found at index 12
//
// the first approach is by comparing every element and then decide pattern found in which index ,so here the no of comparisons are more so not a nice approach
//
//
//th second approach is that by hashmap we can generate the hash code but due to this their will be a no of collision
//if we get the collision the no of spirios sets can be more (the no the less no of spirious sets it will be the more better the algoritm will be)


//so the optimal and final approach is Rabin-Karp algorithm  suppose aaa   1*26power0 + 1*26power0 + 1*26power0   (this will minimize the spiious sets)
//so the rolling hash function for this algoritm is  (x-a)*10 + c

public class question17 {
    public static void main(String[] args) {

    }
}
