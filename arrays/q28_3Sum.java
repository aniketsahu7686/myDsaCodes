import java.sql.Time;
import java.util.*;

public class q28_3Sum {
    // brute force approach
    public static List<List<Integer>> tripletBfa(int[] arr){
        int n =arr.length;
        // initialize a hashset to store the unique triplets
        Set<List<Integer>> ans = new HashSet<>();


        // check all possible triplets:
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if (arr[i] +arr[j] + arr[k] == 0) {
                        // In Java, Arrays.asList is a method provided by the java.util package. It is used to convert an array into a fixed-size list. This method 
                        // is particularly useful when you need to work with APIs or methods that expect a List rather than an array.

                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                        temp.sort(null);
                        ans.add(temp);
                    }
                }
            }
        }

        // to store the set elements in the final ans
        List<List<Integer>> finalans = new ArrayList<>(ans);


        return finalans;
    }

    // Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.  Reason: Here, we are mainly using 3 nested loops. And inserting triplets
    //                  into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just 
    //                  sorting 3 elements every time.
    // Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.


    // better approach
    public static List<List<Integer>> tripletBetterApp(int[] arr){
        int n = arr.length;

        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0;i<n;i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1;j<n;j++){
                // calculate the third element
                int third = -(arr[i] + arr[j]);

                // find the element in the set
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],third);
                    temp.sort(null);
                    ans.add(temp);
                }
                hashset.add(arr[j]);
            }
        }

        // store the set elements in the final answer
         List<List<Integer>> finalans = new ArrayList<>(ans);
         return finalans;
    }

    // Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.  Reason: Here, we are mainly using 3 nested loops. And inserting triplets 
    //                  into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just 
    //                  sorting 3 elements every time.
    // Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for
    //                    storing the array elements in another set.

    

    // optimal approach
    public static List<List<Integer>>  tripletOpt(int[] arr){
        int n =arr.length;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            // remove duplicates
            if (i!=0  && arr[i]  == arr[i-1]) {
                continue;
            }

            // moving 2 pointers :
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                }else if (sum>0) {
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    //skip the duplicates 
                    while (j<k  && arr[j] == arr[j-1]) {
                        j++;
                    }
                    while (j<k && arr[k] == arr[k+1]) {
                        k--;
                    }
                }
            }
        }

        return ans;
    }

    // Time Complexity:  O(NlogN)+O(N2), where N = size of the array.  Reason: The pointer i, is running for approximately N times. And both the pointers j and k 
    //                   combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 
    // Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that
    //                   perspective, space complexity can be written as O(1).
    

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        int n =arr.length;
        // List<List<Integer>> ans = tripletBfa(arr);
        // List<List<Integer>> ans = tripletBetterApp(arr);
        List<List<Integer>> ans = tripletOpt(arr);
        for(List<Integer> it:ans){
            System.out.print("[");
            for(Integer i:it){
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
        System.out.println();
    }
}
