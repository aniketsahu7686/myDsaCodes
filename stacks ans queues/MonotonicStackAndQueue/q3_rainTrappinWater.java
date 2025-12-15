package MonotonicStackAndQueue;

import java.util.Scanner;

public class q3_rainTrappinWater {
    static int trapRWBf(int[] arr){
        int n = arr.length;
        int waterTrapped = 0;
        for(int i=0;i<n;i++){
            int leftMax = 0;int rightMax = 0;
            int j = i;
            while(j>=0){
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }

            j = i;
            while (j<n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }

            int x = Math.min(rightMax,leftMax)-arr[i];
            waterTrapped+=x;
        }
        return waterTrapped;
    }

    // Time Complexity: O(N*N) as for each index we are calculating leftMax and rightMax so it is a nested loop.
    // Space Complexity: O(1).

    static int trapRWBetterApp(int[] arr){
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int waterTrapped = 0;

        //assigning the values for the prefix value that is for the left side of the elevation
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1],arr[i]);
        }


        // assigning the value for the suffix value that is for the right side of the elevation
        suffix[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1], arr[i]);
        }

        for(int i=0;i<n;i++){
            waterTrapped+= Math.min(prefix[i],suffix[i]) - arr[i];
        }

        return waterTrapped;
    }


    // Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.
    // Space Complexity: O(N)+O(N) for prefix and suffix arrays.

    static int trapRWOpt(int[] height){
        int n = height.length;
        int left = 0;int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;

        while (left<=right) {
            if (height[left]<=height[right]) {
                if (leftMax<=height[left]) {
                    leftMax = height[left]; 
                }else{
                    res += leftMax - height[left];
                }
                left++;
            }else{
                if (rightMax<=height[right]) {
                    rightMax = height[right];
                }else{
                    res +=  rightMax - height[right];
                }
                right--;
            }
        }
        return res;        
    }

    // Time Complexity: O(N) because we are using 2 pointer approach.
    // Space Complexity: O(1) because we are not using anything extra.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]  = sc.nextInt();
        }
        q3_rainTrappinWater ss = new q3_rainTrappinWater();
        // int ans = ss.trapRWBf(arr);
        // int ans  = ss.trapRWBetterApp(arr);
        int ans = ss.trapRWBetterApp(arr);
        System.out.println(ans);
    }
}
