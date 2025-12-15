import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.HandlerBase;

public class q21_longestConsecutiveSequenceInAnArray {
    // brute force approach
    // linear search 
    public static boolean lineraSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if (arr[i]==target) {
                return true;
            }
        }
        return false;
    }
    public static int longestConsectiveBf(int[] arr,int n){
        int longest = 1;

        // pick for an element and search for its consecutive numbers
        for(int i=0;i<n;i++){
            int x = arr[i];
            int count = 1;

            // search for consecutive numbers using the linear search
            while (lineraSearch(arr,x+1)==true) {
                x+=1;
                count+=1;
            }

            longest = Math.max(longest, count);
        }
        return longest;
    }


    // Time Complexity: O(N2), N = size of the given array. Reason: We are using nested loops each running for 
    //                  approximately N times.
                     
    // Space Complexity: O(1), as we are not using any extra space to solve this problem.
    

    // better approach
    public static int longestConsecutiveBetterApp(int[] arr,int n){
        if (n==0) {
            return 0;
        }

        // sort the array
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;


        // find the longest subsequence
        for(int i=0;i<n;i++){
            if (arr[i]-1 == lastSmaller) {
                // arr[i] is the  next element of the current sequence
                count+=1;
                lastSmaller = arr[i];
            }else if (arr[i] != lastSmaller) {
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    // Time Complexity: O(NlogN) + O(N), N = size of the given array. Reason: O(NlogN) for sorting the array. To find the longest sequence, we are using a loop 
    //                  that results in O(N).
    // Space Complexity: O(1), as we are not using any extra space to solve this problem.


    // optimal approach
    public static int longestConsectiveOpt(int[] arr,int n){
        if (n==0) {
            return 0;
        }

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        
        // find the largest sequence 
        for(int it:set){
            // if 'it' is a starting number
            if (!set.contains(it-1)) {
                // find the consecutive numbers
                int count = 1;
                int x = it;

                while (set.contains(x+1)) {
                    x = x+1;
                    count = count + 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    // Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array. Reason: O(N) for putting all the elements into the set data structure.
    //                  After that for every starting element, we are finding the consecutive elements. Though we are using nested loops, the set will be traversed 
    //                  at most twice in the worst case. So, the time complexity is O(2*N) instead of O(N2).
    // Space Complexity: O(N), as we are using the set data structure to solve this problem.
    
    // Note: The time complexity is computed under the assumption that we are using unordered_set and it is taking O(1) for the set operations. 

    // If we consider the worst case the set operations will take O(N) in that case and the total time complexity will be approximately O(N2). 
    // And if we use the set instead of unordered_set, the time complexity for the set operations will be O(logN) and the total time complexity will be O(NlogN).

    

    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 2, 3, 4};
        int n = 6;
        // int ans = longestConsecutiveBetterApp(arr,n);
        int ans = longestConsectiveOpt(arr, n);
        System.out.println("The longest consecutive sequence is " + ans);
    }
    
}
