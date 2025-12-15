import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class q25_countSubarraySumEqualToK {
    // brute force approach
    public static int countSubarrEqKBFA(int[] arr,int K){
        int n =arr.length;

        // no of subarrays
        int cnt = 0;

        // starting index for i
        for(int i=0;i<n;i++){
            // starting index for j
            for(int j=i;j<n;j++){

                // calculate the sum for the subarray [i...j]
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }

                // increment the cnt if ans is equal to k
                if (sum==K) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // Time Complexity:  O(N3), where N = size of the array. Reason: We are using three nested loops here. Though all are not running
    //                   for exactly N times, the time complexity will be approximately O(N3).
    // Space Complexity: O(1) as we are not using any extra space.

    // better approach

    public static int countSubarrEqKBetterApp(int[] arr,int K){
        int n =arr.length;

        // no of subarrays
        int cnt = 0;

        // starting index for i
        for(int i=0;i<n;i++){
            int sum = 0;  // intialise sum as 0
            // starting index for j
            for(int j=i;j<n;j++){

                // calculate the sum 
                sum +=arr[j];

                // increment the cnt if ans is equal to k
                if (sum==K) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    // Time Complexity:  O(N2), where N = size of the array. Reason: We are using two nested loops here. As each of them is running 
    //                   for exactly N times, the time complexity will be approximately O(N2).
    // Space Complexity: O(1) as we are not using any extra space.


    // optimal  approach
    public static int countSubarrEquToKOpt(int[] arr,int K){
        int n = arr.length;

        // initialize a hashmap
        HashMap<Integer,Integer>  map = new HashMap<>();

        int preSum = 0;
        int cnt = 0;

        // setting 0 in the map
        map.put(0, 1);

        for(int i=0;i<n;i++){
            // add the current element to the prefix sum
            preSum += arr[i];

            // calculate the x-k
            int remove = preSum - K;

            // add the number of subarrays to be removed
            cnt += map.getOrDefault(remove, 0);

            // update the count of prefix sum in the map
            map.put(preSum,map.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    // Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
    //                  Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N) but if we are using a map data
    //                   structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.
    // Space Complexity: O(N) as we are using a map data structure.


    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int K = 6;
        // System.out.println(countSubarrEqKBFA(arr, K));
        // System.out.println(countSubarrEqKBetterApp(arr, K));
        System.out.println(countSubarrEquToKOpt(arr, K));

    }
}
