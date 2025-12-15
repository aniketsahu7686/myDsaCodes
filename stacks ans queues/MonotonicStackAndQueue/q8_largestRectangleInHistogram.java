 package MonotonicStackAndQueue;

import java.util.Scanner;
import java.util.Stack;

class q8_largestRectangleInHistogram {

    // brute force approach
    public static int largestAreaBf(int[] arr){
        int n = arr.length;
        int maxArea = 0;
        for(int i=0;i<n;i++){
            // here whenever we are coming to a new i, then we take the minHeight as the i bar
            int minHeight = Integer.MAX_VALUE;

            for(int j=i;j<n;j++){
                minHeight = Math.min(minHeight,arr[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1)); // here j and i stands for the right ans left smaller of the current element
            }
        }
        return maxArea;
    }

    // Time Complexity: O(N*N ) 
    // Space Complexity: O(1)


    // Better approach
    public static int largestAreaBetterAp(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        // so first we will find out the leftSmaller indexes of for every bar and store it in leftSmaller array
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                st.pop();   // we are removing it from stack because if in initially it is greater than current height ,then it will not be smaller for the upcoming heights
            }
            if (st.isEmpty()) {
                leftSmaller[i] = 0;
            }else{
                leftSmaller[i] = st.peek() + 1;
            }
            st.push(i);
        }

         // next we will find out the rightSmaller indexes of for every bar and store it in rightSmaller array
         for(int i=n-1;i>=0;i--){
            while (!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightSmaller[i] = n-1;
            }else{
                rightSmaller[i] = st.peek()-1;
            }
            st.push(i);
         }

         int maxArea = 0;
         for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea, heights[i]*(rightSmaller[i]-leftSmaller[i]+1));
         }

         return maxArea;
    }

    // Time Complexity: O( N )
    // Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array


    //optimal approach

    public static int largestAreaOpt(int[] height){
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;
        int n = height.length;
        for(int i=0;i<=n;i++){
            while (!st.isEmpty() && (i==n || height[st.peek()]>=height[i])) {
                int  tempHeight = height[st.peek()];
                st.pop();

                int width;
                if(st.empty()){
                    width = i;
                }else{
                    width = i - st.peek() - 1;  // here i is the rightsmaller and st.peek() is the left smaller 
                }
                maxArea = Math.max(maxArea, width*tempHeight);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        // int ans =  largestAreaBf(arr);
        // int ans = largestAreaBetterAp(arr);
        int ans = largestAreaOpt(arr);
        System.out.println(ans);
    }
}