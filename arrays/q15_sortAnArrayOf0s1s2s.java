

import java.util.ArrayList;
import java.util.Arrays;

public class q15_sortAnArrayOf0s1s2s {
    // brute force approach
    // we can use any sorting algorithm to sort as only three elements are present 

    // TC : O(N)
    // SC : O(1)

    // better approach
    public static void sortAnArrayOf0s1s2s(ArrayList<Integer> arr,int n){
        int count_0 = 0,count_1 = 0,count_2 = 0;

        for(int i=0;i<n;i++){
            if (arr.get(i)==0) {
                count_0++;
            }else if (arr.get(i) == 1) {
                count_1++;
            }else{
                count_2++;
            }
        }

        // replace the arrays in the original array
        // replacing 0s
        for(int i=0;i<count_0;i++){
            arr.set(i, 0);
        }
        // replacing 1s
        for(int i=count_0;i<count_0 + count_1;i++){
            arr.set(i,1);
        }
        // replacing 2s
        for(int i=count_0 + count_1;i<n;i++){
            arr.set(i, 2);
        }
    }

    // TC : O(N) + O(N), where N = size of the array. First O(N) for counting the number of 0’s, 1’s, 2’s, and second O(N) for placing 
    // them correctly in the original array.
    // SC : O(1) as we are not using any extra space.

    // optimal approach
    // Dutch National flag algorithm
    public static void sortAnArrayOf0s1s2sopt(ArrayList<Integer> arr,int n){
        // 3 pointers
        int low = 0 , mid = 0 , high = n - 1;

        while (mid<=high) {
            if (arr.get(mid)==0) {
                // swapping the arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++; 
                mid++;
            }
            else if (arr.get(mid)==1) {
                mid++;
            }else{
                // swapping arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid,arr.get(high));
                arr.set(high, temp);

                high--;
            }
        }
    }

    // Time Complexity: O(N), where N = size of the given array. Reason: We are using a single loop that can run at most N times.
    // Space Complexity: O(1) as we are not using any extra space.

    public static void main(String[] args) {
        int n = 16;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0,1,2,1,2,1,2,0,2,1,1,2,1,0,0,2}));
        // sortAnArrayOf0s1s2s(arr, n);
        sortAnArrayOf0s1s2sopt(arr, n);
        for(int i=0;i<n;i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
