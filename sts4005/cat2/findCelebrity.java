package cat2;

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


import java.util.Stack;

public class findCelebrity {
    // solution 
    public static int findCeleb(int[][] arr, int n) {
        // first we will make a stack and put all the elements smaller than n 
        Stack<Integer> stack = new Stack<>();

        // here we store all the elements in the stack from 0 to n-1
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }


        // so now stack will be greater than 1 , means we will run the loop until the stack contains 1 element only 
        while (stack.size() > 1) {
            int col = stack.pop();
            int row = stack.pop();

            // here if the row no knows the column , then definately row no cannot be the celebrity so we will discard it and add the col back to the stack 
            if (arr[row][col] == 1) {
                stack.push(col);
            } else { // if the row no doesn't no the column then , not sure but it can be the celebrity  so we will discard the column and add the row to the stack
                stack.push(row);
            }
        }
        int potentialCelebrity = stack.pop();

        // Check if the potential celebrity is a real celebrity
        for (int i = 0; i < n; i++) {
            if (i==potentialCelebrity) {
                continue;
            }
            if (arr[i][potentialCelebrity] == 0) {
                return -1;
            }
        }

        for(int j=0;j<n;j++){
            if (j==potentialCelebrity) {
                continue;
            }
            if (arr[potentialCelebrity][j]==1) {
                return -1;
            }
        }

        return potentialCelebrity; // it is a  celebrity
    }

    public static void main(String[] args) {
        int[][] arr = {{0 ,0,1 , 0},
        {0 , 0 ,1, 0}, 
        {0,  0,0, 0},
        {0,  0,1, 0}};
        int n = 4;
        int celebrity = findCeleb(arr, n);

        if (celebrity != -1) {
            System.out.println("The celebrity is: " + celebrity);
        } else {
            System.out.println("There is no celebrity in the party.");
        }
    }
}

