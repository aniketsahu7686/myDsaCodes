import java.sql.Time;

public class q30_lengthOfLgstSubArraySum0 {
    // brute force approach
    public static int longestSubarray(int[] arr){
        int n = arr.length;
        int max = 0;


        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += arr[j];
                if (sum==0) {
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
    
    // Time Complexity: O(N^2) as we have two loops for traversal
    // Space Complexity: O(1) as we aren’t using any extra space.


    public static void main(String[] args) {
        int[] arr = {9,-3,3,-1,6,-5};
        System.out.println(longestSubarray(arr));
    }
}
