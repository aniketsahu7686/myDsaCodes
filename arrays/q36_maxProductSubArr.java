import java.sql.Time;

public class q36_maxProductSubArr {
    // brute force approach
    public static int maxProductSubArrBfa(int[] arr){
        int n = arr.length;
       int max = Integer.MIN_VALUE;

       for(int i=0;i<n-1;i++){
        for(int j = i+1;j<n;j++){
            int product = 1;
            for(int k = i;k<=j;k++){
                product *= arr[k];
            }
            max = Math.max(max, product);
        }
       }
       return max;
    }

    // Time Complexity: O(N3) Reason: We are using 3 nested loops for finding all possible subarrays and their product.
    // Space Complexity: O(1) Reason: No extra data structure was used


    // better approach
    public static int maxProductSubArrBetterApp(int[] arr){
       int n = arr.length;
       int max = arr[0];

       for(int i=0;i<n-1;i++){
            int product = arr[i];
            for(int j=i+1;j<n;j++){
                product*=arr[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }

    // Time Complexity:  O(N2) Reason: We are using two nested loops
    // Space Complexity: O(1)  Reason: No extra data structures are used for computation

    // optimal solution :
    public static int maxProductSubArrOpt(int[] arr){
        int n =arr.length;

        int prefix = 1 ,suffix = 1;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if (prefix==0) {
                prefix = 1;
            }
            if (suffix==0) {
                suffix = 1;
            }

            prefix *= arr[i];
            suffix *= arr[n-i-1];

            ans =Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }


    // Time Complexity: O(N), N = size of the given array. Reason: We are using a single loop that runs for N times.
    // Space Complexity: O(1) as No extra data structures are used for computation.

    
    public static void main(String[] args) {
        // int[] arr = {1,2,-3,0,-4,-5};
        int[] arr = {1,2,3,4,5,0};
        int n =arr.length;
        // int max = maxProductSubArrBfa(arr);
        // int max = maxProductSubArrBetterApp(arr);
        int max = maxProductSubArrOpt(arr);
        System.out.println(max);
    }
}
