import java.sql.Time;
import java.util.*;
public class q19_nextPermutation {
    // brute force approach
    public static int[] nextPermutationBf(int[]  arr ,int n){

        return arr;
    }

    // Time Complexity:  For finding, all possible permutations, it is taking N!xN. N represents the number of elements present in 
    //                   the input array. Also for searching input arrays from all possible permutations will take N!. Therefore,
    //                    it has a Time complexity of O(N!xN).

    // Space Complexity : Since we are not using any extra spaces except stack spaces for recursion calls. So, it has a space 
    // complexity of O(1).



    // optimal approach
    public static List<Integer> nextGreaterPermutationOpt(List<Integer> arr){
        // size of the array
        int n = arr.size();


        // step 1 : find the break point
        int ind = -1;  // break point
        for(int i=n-2;i>=0;i--){
            if (arr.get(i)<arr.get(i+1)) {
                // index i is the break point 
                ind = i;
                break;
            }
        }

        // if break point does not exist
        if (ind == -1) {
            // reverse the whole array
            Collections.reverse(arr);
            return arr;
        }


        // step 2 : find the next greater element and swap it with arr[ind]
        for(int i=n-1;i>ind;i--){
            if (arr.get(i)>arr.get(ind)) {
                int temp = arr.get(i);
                arr.set(i, arr.get(ind));
                arr.set(ind, temp);
                break;
            }
        }

        // step 3 : reverse the right half
        List<Integer> sublist = arr.subList(ind+1, n);
        Collections.reverse(sublist);

        return arr;
    }

    // Time Complexity: O(3N), where N = size of the given array Finding the break-point, finding the next greater element, and reversal at the end takes O(N)
    //                  for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(3N).
    // Space Complexity: Since no extra storage is required. Thus, its space complexity is O(1).

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(new Integer[] {2,1,5,4,3,0,0});
        List<Integer> ans = nextGreaterPermutationOpt(arr);


        System.out.println("The next permutation is :");
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i) + " ");
        }
        System.out.println();
    }
}
