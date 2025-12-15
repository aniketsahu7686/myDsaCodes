import java.util.HashMap;

public class q13_findTheSubArrayWithGivenSumK {
    // brute force approach
    public static int findTheSubarrayWithSumKBf(int[] arr,int x){
        // this is the length of the arr 
        int length = 0;
        // starting index
        for(int i=0;i<arr.length;i++){
            // ending index 
            for(int j=i;j<arr.length;j++){
                // add all the elements of subarray  = a[i.....j]
                long sum = 0;
                for(int k=0;k<=j;k++){
                    sum += arr[k];
                }
                if (sum==x) {
                    // here we are checking the max length of the subarray 
                    length  = Math.max(length, j-i+1);
                }
            }
        }
        return length;
    }
    // TC : O(N3) approx., where N = size of the array. Reason: We are using three nested loops, each running approximately N times.
    // SC : O(1) as we are not using any extra space.

    // optimized brute force approach
    // little optimizing the brute force (means instead of 3 nested loops we use two nested loops)
    public static int findTheSubarrayWithSumKOptimzingBf(int[] arr,int x){
         // this is the length of the arr 
         int length = 0;
         // starting index
         for(int i=0;i<arr.length;i++){
             // ending index 
             int sum = 0;
             for(int j=i;j<arr.length;j++){
                // add the current element to the  subarray a[i...j-1]
                 sum += arr[j];
                 if (sum==x) {
                     // here we are checking the max length of the subarray 
                     length  = Math.max(length, j-i+1);
                 }
             }
         }
         return length;
    }
   // TC :  O(N2) approx., where N = size of the array , Reason: We are using two nested loops, each running approximately N times.
   // SC: O(1) as we are not using any extra space.


   // using hashing
   public static int findTheSubarrayWithSumKBetterApp(int[] arr, long k){
    HashMap<Long,Integer> map = new HashMap<>();
    long sum = 0;
    int maxLength = 0;

    for(int i=0;i<arr.length;i++){
        // calculate the prefix sum till index i
        sum  += arr[i];

        // if sum equals to k update the maxLength
        if (sum==k) {
            maxLength = Math.max(maxLength, i+1);
        }

        // calculate the sum of the remaining part  (x-k)  here x means the total sum 
        long rem = sum - k;

        // calculate the length and update maxLength
        if (map.containsKey(rem)) {
            int length = i - map.get(rem);
            maxLength = Math.min((maxLength), length);
        }

        // finally update the map checking the conditions
        if (!map.containsKey(sum)) {
            map.put(sum, i);
        }
    }
    return maxLength;
   }

   // TC : O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array. Reason: For example, if we are using an unordered_map
   //      data structure in C++ the time complexity will be O(N)(though in the worst case, unordered_map takes O(N) to find an element and the time complexity 
   //      becomes O(N2)) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop
   //      to traverse the array.
   
   // SC: O(N) as we are using a map data structure.

   // optimal approach
   public static int findTheSubarrayWithSumKOptApp(int[] arr,int k){
    // left and right are the two pointers
    int left = 0, right =0;
    long sum = arr[0];
    int maxLength = 0;
    while (right<arr.length) {
        // if sum > k , reduce the subarray from left until sum becomes less or equal to k
        if (left<=right && sum>k) {
            sum-=arr[left];
            left++;
        }

        // if the sum = k , update the maxlength
        if (sum==k) {
            maxLength = Math.max(maxLength, right-left+1);
        }


        // as sum is now the first element of the array move the right pointer 
        right++;
        if (right<arr.length) {
            sum += arr[right];
        }
    }
    return maxLength;
   }


    // TC : O(2*N), where N = size of the given array. Reason: The outer while loop i.e. the right pointer can move up to index n-1(the last index). Now, the inner
    // while loop i.e. the left pointer can move up to the right pointer at most. So, every time the inner loop does not run for n times rather it can run for n times
    // in total. So, the time complexity will be O(2*N) instead of O(N2).
    
    // SC: O(1) as we are not using any extra space.
    public static void main(String[] args) {
        int[] arr = {2,3,5,1,9};
        int x = 10;
        // System.out.println(findTheSubarrayWithSumKBf(arr, x));
        // System.out.println(findTheSubarrayWithSumKOptimzingBf(arr, x));
        System.err.println(findTheSubarrayWithSumKOptApp(arr, x));
    }
}