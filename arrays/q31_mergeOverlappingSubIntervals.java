import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class q31_mergeOverlappingSubIntervals {

    // brute force approach
    public static List<List<Integer>> mergeOverLappInterValsBfa(int[][] arr){
        int n = arr.length;

        
        // This code snippet is sorting an array of arrays (arr) based on the values in the first element of each sub-array. 

        // Arrays.sort(arr, ...) - This method is used to sort the elements of the array arr. The sorting is done based on the comparator provided.

        // new Comparator<int[]>() { ... } - This creates an anonymous inner class that implements the Comparator interface for arrays of integers. The Comparator
        //  interface is used to define a custom ordering for objects.

        // public int compare(int[] a, int[] b) - This is the method required by the Comparator interface. It compares two arrays (a and b) based on the values in their 
        // first elements (a[0] and b[0]).

        // return a[0] - b[0]; - This comparison returns a negative value if the first element of array a is smaller than the first element of array b, zero if they are
        // equal, and a positive value if the first element of array a is greater than the first element of array b. This is the logic used by the Arrays.sort method to 
        // determine the order of elements during sorting.
        
        // sort the given intervals
        Arrays.sort(arr,new Comparator<int[]>() {
            public int compare (int[] a,int[] b){
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        // select an interval :
        for(int i=0;i<n;i++){
            int start = arr[i][0];
            int end = arr[i][1];


            // skip all the merged intervals :
            // Suppose if we are at  [2,4] , it is already a part of [1,6]
            // this condition apply when if we have some previous interval which means the list (ans) is not empty and the end should be lying in the range , if it is not then this will be a part of the list (ans)
            if (!ans.isEmpty() && end<=ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // check the rest of the intervals :
            for(int j=i+1;j<n;j++){
                if (arr[j][0] <=end) {
                    end = Math.max(end, arr[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }

    // Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array. Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that,
    //                  we are using 2 loops i and j. But while using loop i, we skip all the intervals that are merged with loop j. So, we can conclude that every
    //                  interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time complexity will be 2*N instead of N2.
    // Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.


    // optimal approach
    public static List<List<Integer>> mergeOverLappInterValsOpt(int[][] arr){
        int n =arr.length;

        // sort the given intervals :
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            // if the current interval does not lie in the last interval
            if (ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1).get(1)) {
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
            // if the current interval lies in the last interval 
            else{
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1),arr[i][1]));
            }
        }

        return ans;
    }

    // Time Complexity: O(N*logN) + O(N), where N = the size of the given array. Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we
    //                  are just using a single loop that runs for N times. So, the time complexity will be O(N
    // Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.

    

    public static void main(String[] args){
        int[][] arr ={{1,3},{8,10},{2,6},{15,18}};
        // List<List<Integer>> ans = mergeOverLappInterValsBfa(arr);
        List<List<Integer>> ans = mergeOverLappInterValsOpt(arr);
        for(List<Integer> it:ans){
            System.out.print("[" + it.get(0) +  "," + it.get(1) + "]");
        }
        System.out.println();
    }
}