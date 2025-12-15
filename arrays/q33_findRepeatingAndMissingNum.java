import java.sql.Time;
import java.util.*;

public class q33_findRepeatingAndMissingNum {
    // brute force approach
    public static int[] findRepeatingAndMissingNumBfa(int[] arr){
        int n =arr.length;
        int repeating = -1, missing = -1;
        
        // find the repeating and missing number :
        for(int i=1;i<=n;i++){
          int cnt = 0;
          for(int j=0;j<n;j++){
            if (arr[j] == i) {
                cnt++;
            }
          }

          if (cnt==2) {
            repeating = i;
          }else if (cnt==0) {
            missing = i;
          }

          if (repeating != -1 && missing!=-1) {
            break;
          }
        }

        int[] ans = {repeating,missing};
        return ans;
    }

    // Time Complexity: O(N2), where N = size of the given array. Reason: Here, we are using nested loops to count occurrences of every element between 1 to N.
    // Space Complexity: O(1) as we are not using any extra space.

    // better approach
    public static int[] findRepeatingAndMissingNumBetterApp(int[] arr){
        int n =arr.length;
        int[] hash = new int[n+1];

        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }

        // find the repeating and missing number :
        int repeating = -1,missing = -1;
        for(int i=1;i<=n;i++){
            if (hash[i]==2) {
                repeating = i;
            }else if (hash[i]==0) {
                missing = i; 
            }
        }

        int[] ans = {repeating,missing};
        return ans;
    }

    // optimal approach
    public static int[] findRepeatingAndMissingNumOpt(int[] arr){
        int n =arr.length;

        // find the Sn and S2n
        // sum of all the numbers from 1 to n
        long Sn = (n*(n+ 1))/2;

        // sum of squares of all the numbers from 1 to n 
        long S2n = (n*(n+1)*(2*n+1))/6;


        // calculate the S and S2
        long S = 0, S2 = 0;
        for(int i=0;i<n;i++){
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }

        // S-Sn = X-Y :
        long val1 = S-Sn;

        // S2 - S2N  = X^2 - Y^2;
        long val2 = S2 - S2n;

        // Find X+Y = (X^2 - Y^2)/(X-Y):
        val2 = val2/val1;



        // Fidn X and Y:X = ((X+Y)+(X-Y))/2 and Y = X - (X-Y)
        // Here the , X-Y = val1 and X+Y = val2 :
        long x = (val1 + val2)/2;
        long y = x - val1;

        int[] ans = {(int)x,(int)y};
        return ans;
    }

    // Time Complexity: O(N), where N = the size of the given array. Reason: We are using only one loop running for N times. So, the time complexity will be O(N).
    // Space Complexity: O(1) as we are not using any extra space to solve this problem.

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,4,6,7,5};
        // int[] ans = findRepeatingAndMissingNumBfa(arr);
        // int[] ans = findRepeatingAndMissingNumBetterApp(arr);
        int[] ans = findRepeatingAndMissingNumOpt(arr);

        System.out.println(" { " + ans[0] + " " + ans[1] + " )");
    }
}