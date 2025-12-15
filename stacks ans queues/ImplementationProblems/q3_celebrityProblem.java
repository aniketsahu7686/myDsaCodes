package ImplementationProblems;

import java.util.Scanner;
import java.util.Stack;

// Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition 
// of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

// Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions
// \ like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one)
//  by asking as few questions as possible (in the asymptotic sense).

// You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n).
//  There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party.
//   If there is no celebrity, return -1.


// ans is coming wrong so check it again :
public class q3_celebrityProblem {
    // first we will make a stack and put all the elements smaller than n 
    public static int celebrityProblem(int[][] matrix){
        int n = matrix.length;
        Stack<Integer> st = new Stack<>();

        // here we store all the elements in the stack from 0 to n-1
        for(int i=0;i<n;i++){
            st.push(i);
        }

        // so now stack will be greater than 1 , means we will run the loop until the stack contains 1 element only 
        while(st.size()>1){
            int row = st.pop();
            int col = st.pop();

            // here we are checking that who knows whom and finding out the celebrity
            if (matrix[row][col]==0) {
                st.push(row);
            }else{
                st.push(col);
            }
        }
        if (st.isEmpty()) {
            return -1;
        }

        int celebrity = st.pop();

        // Check if the potential celebrity is a real celebrity
        for(int i=0;i<n;i++){
            if (i!=celebrity && (matrix[celebrity][i]==1 || matrix[i][celebrity]==0) ) {
                return -1;
            }
        }
        return celebrity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        // int[][] arr = {{0 ,0,1 , 0},
        // {0 , 0 ,1, 0}, 
        // {0,  0,0, 0},
        // {0,  0,1, 0}}; 

        int ans = celebrityProblem(arr);
        System.out.println(ans);
    }
}


// TC : O(N)
// SC : O(N)