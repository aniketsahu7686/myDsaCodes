import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

public class q20_leaderInAnArray {
    // brute force approach
    public static ArrayList<Integer> printLeadersBf(int[] arr,int n){
        ArrayList<Integer> ans = new ArrayList<>();

        
        for(int i=0;i<n;i++){
            boolean leader = true;

            // checking whether arr[i] is greater than all the elements in its right side
            for(int j=i+1;j<n;j++){
                if (arr[j]>arr[i]) {
                    // if any element found is greater than the current leader , curr element is not the leader 
                    leader = false;
                    break;
                }
            }


            // push all the leaders in the ans array
            if (leader==true) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }

    // Time Complexity: O(N^2) { Since there are nested loops being used, at the worst case n^2 time would be consumed }.
    // Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans array will be used
    //                   in the worst case }.


    // optimal approach
    public static ArrayList<Integer> printLeadersOpt(int[] arr,int n){
        ArrayList<Integer> ans = new ArrayList<>();

        // last element of the array is always a leader, push it to the ans
        int max = arr[n-1];
        ans.add(max);

        // start checking from the end whether a number is greater than max no. from right , hence leader
        for(int i=n-2;i>=0;i--){
            if (arr[i]>max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        return ans;
    }


    // Time Complexity: O(N) { Since the array is traversed single time back to front, it will consume O(N) of time where N = size of the
    //                  array }.
    // Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in
    //                   the worst case }.

    public static void main(String[] args) {
        // for brute force approach
        // int n = 6;
        // int[] arr = {10,22,12,3,0,6};

        // ArrayList<Integer> ans = printLeadersBf(arr, n);
        // for(int i=0;i<ans.size();i++){
        //     System.out.println(ans.get(i) + " ");
        // }


        // for optimal approach
         int n = 6;
         int arr[]=  {10, 22, 12, 3, 0, 6};


        ArrayList<Integer> ans= printLeadersOpt(arr,n);


        // if we should print the ans in reverse order then , this is apply :
        
        // Collections.sort(ans, Collections.reverseOrder());
  
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
