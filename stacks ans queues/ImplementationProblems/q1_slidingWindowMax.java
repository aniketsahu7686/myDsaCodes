package ImplementationProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class q1_slidingWindowMax {
    // brute force approach
    static void getMax(int[] arr,int left,int right,ArrayList<Integer> ans ){
        int max =Integer.MIN_VALUE;

        for(int i=left;i<=right;i++){
            max = Math.max(max, arr[i]);
        }

        ans.add(max);
    }
    public static ArrayList<Integer> slidingWinMaxBf(int[] arr,int k){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int left = 0,right = k-1;
        while(right<n){
            getMax(arr,left,right,ans);
            left++;
            right++;
        }

        return ans;
    }

    // Time Complexity: O(N^2)
    // Reason: One loop for traversing and another to findMax
    // Space Complexity: O(K) 
    // Reason: No.of windows


    // optimal approach
    public static int[] slidingWinMaxOpt(int[] arr,int k){
        int n = arr.length;
        int[] ans = new int[n-k+1];
        int index = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            // first we will check if any index contains at the front of the deque that is not in the range of windows
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }

            // no remove the smaller elements in k range as they are useless
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }

            dq.offer(i);
            if (i>=k-1) {
                ans[index++] =  arr[dq.peek()];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // ArrayList<Integer> ans;
        // ans = slidingWinMaxBf(arr, k);
        // for(int i=0;i<ans.size();i++){
        //     System.out.print(ans.get(i)  + " ");
        // }

        int[] ans = slidingWinMaxOpt(arr, k);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }

    }
}
