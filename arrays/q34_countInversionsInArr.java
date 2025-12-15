import java.sql.Time;
import java.util.ArrayList;

public class q34_countInversionsInArr {
    // brute force approach
    public static int countInversionBfa(int[] arr){
        int n = arr.length;
        int cnt = 0;


        for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
            if (arr[i]>arr[j]) {
                cnt++;
            }
           }
        }

        return cnt;
    }

    // Time Complexity: O(N2), where N = size of the given array. Reason: We are using nested loops here and those two loops roughly
    //                  run for N times.
    // Space Complexity: O(1) as we are not using any extra space to solve this problem.


    // optimal approach

//     The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just a one-line addition inside the merge() function.
//      Inside the merge(), we need to add the number of pairs to the count when a[left] > a[right].
    
//     The steps of the merge() function were the following:

// In the merge function, we will use a temp array to store the elements of the two sorted arrays after merging. Here, the range of the left array is low to mid and 
 // the range for the right half is mid+1 to high.
// Now we will take two pointers left and right, where left starts from low and right starts from mid+1.
// Using a while loop( while(left <= mid && right <= high)), we will select two elements, one from each half, and will consider the smallest one among the two. Then,
//  we will insert the smallest element in the temp array. 
// After that, the left-out elements in both halves will be copied as it is into the temp array.
// Now, we will just transfer the elements of the temp array to the range low to high in the original array.
// Modifications in merge() and mergeSort(): 

// In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the merge().
// While comparing a[left] and a[right] in the 3rd step of merge(), if a[left] > a[right], we will simply add this line:
// cnt += mid-left+1 (mid+1 = size of the left half)
// Now, we will return this cnt from merge() to mergeSort(). 
// Inside mergeSort(), we will keep another counter variable that will store the final answer. With this cnt, we will add the answer returned from mergeSort() of the left half, mergeSort() of the right half, and merge().
// Finally, we will return this cnt, as our answer from mergeSort().



    private static int merge(int[] arr,int low,int mid,int high){
        // temporary array
        ArrayList<Integer> temp = new ArrayList<>();

        // starting index of left half of arr
        int left = low;
        // starting index of right half of arr
        int right = mid+1;

        // modification 1: cnt variable to count the pairs :
        int cnt = 0;


        // storing elements in the temporary array in a sorted manner 
        while (left<=mid && right<=high) {
            if (arr[left]<=arr[right]) {
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                // modification 2 :
                cnt += (mid-left+1);
                right++;
            }
        }


        //  if elements on the left half are still left
        while (left<=mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left
        while (right<=high) {
            temp.add(arr[right]);
            right++; 
        }

        // tranfering all elements from temporary to arr
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }

        // modification 3 :
        return cnt;
    }
    public static int mergeSort(int[] arr,int low,int high){
        int cnt = 0;
        if (low>=high) {
            return cnt;
        }
        int mid = low + (high-low)/2;
        // left half
        cnt += mergeSort(arr, low, mid);
        // right half
        cnt += mergeSort(arr, mid+1, high);
        // merging sorted halves
        cnt += merge(arr, low, mid,high);

        return cnt;
    }
    public static int countInversionOpt(int[] arr,int n){
        // count the number of pairs :
        return mergeSort(arr, 0, n-1);
    }

    // Time Complexity: O(N*logN), where N = size of the given array. Reason: We are not changing the merge sort algorithm except by adding a variable to it.
    //                  So, the time complexity is as same as the merge sort.
    // Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int n =arr.length;
        int cnt = countInversionBfa(arr);
        System.out.println(cnt);
    }
}