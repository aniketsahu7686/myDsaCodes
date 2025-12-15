import java.sql.Time;

public class q17_kadanesAlgoMaxSubarray{

    //brute force approach

    public static int kadanesAlgoBf(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum = 0;
                for(int k = i ;k<=j;k++){
                    sum+=arr[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // Time Complexity: O(N3), where N = size of the array. Reason: We are using three nested loops, each running approximately N times.
    // Space Complexity: O(1) as we are not using any extra space.


    // better approach
    public static int kadanesAlgoBetterApp(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                 // current subarray = arr[i.....j]
                //add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];
                max = Math.max(max, sum);
            }
            // max = Math.max(max, sum);
        }
        return max;
    }

    // Time Complexity: O(N2), where N = size of the array. Reason: We are using two nested loops, each running approximately N times
    // Space Complexity: O(1) as we are not using any extra space.


    // optimal approach
    public static int kadanesAlgoOptimalApproach(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<arr.length;i++){

            sum += arr[i];

            if (sum>max) {
                max = sum;
            }
            
             // If sum < 0: discard the sum calculated
            if (sum<0) {
                sum = 0;
            }


            // To consider the sum of the empty subarray
            //if (maxi < 0) maxi = 0;
        }
        return max;
    }
    

    // Time Complexity: O(N), where N = size of the array. Reason: We are using a single loop running N times.
    // Space Complexity: O(1) as we are not using any extra space.
    

    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        // System.out.println(kadanesAlgoBf(arr));
        // System.out.println(kadanesAlgoBetterApp(arr));
        System.out.println(kadanesAlgoOptimalApproach(arr));
    }
}