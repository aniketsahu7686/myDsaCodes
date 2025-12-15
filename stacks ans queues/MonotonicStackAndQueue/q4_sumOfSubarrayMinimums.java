package MonotonicStackAndQueue;

import java.util.Scanner;

class q4_sumOfSubarrayMinimums {

    // first just learn this that how to find out the subarray of the given arrays
    public static void Subarrays(int[] arr){
        int n = arr.length;
        // here x is the no of the subarrays
        int x = (n*(n+1))/2;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<j;k++){
                    System.out.println(arr[k]);
                }
            }
        }
    }

    // brute force approach
    public static int findminOfSubArrBf(int[] arr){
        int n = arr.length;
        int ans = 0;

        for(int i=0;i<n;i++){
            // assign the minimum element intially for every iteration starting from i
            int min_ele = arr[i];
            for(int j=i;j<n;j++){
                // compare every time the minimum elements and add to the ans
                min_ele = Math.min(min_ele,arr[j]);
                ans += min_ele;
            }
        }
        return ans;
    }

    // Time Complexity: O(N2),because of two nested for loops 
    // Space Complexity: O(1)

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = findminOfSubArrBf(arr);
        System.out.println(ans);
    }
}