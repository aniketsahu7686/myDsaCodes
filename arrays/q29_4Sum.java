import java.sql.Time;
import java.util.*;



public class q29_4Sum {
    // brute force approach
    public static List<List<Integer>> quadrupletsBfa(int[] arr, int target){
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();


        // checking all the possible quadruplets
        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1 ; k<n; k++){
                    for(int l = k+1 ; l<n ; l++){
                        // taking bigger data type to stop the integer overflow
                        long sum = (long) arr[i] + arr[j];
                        sum += arr[k];
                        sum += arr[l];


                        if (sum==target) {
                            List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            temp.sort(null);
                            ans.add(temp); 
                        }

                    }
                }
            }
        }

        List<List<Integer>> finalAns = new ArrayList<>(ans);
        return finalAns;
    }

    // Time Complexity: O(N4), where N = size of the array. Reason: Here, we are mainly using 4 nested loops. But we not considering the time complexity of sorting
    //                  as we are just sorting 4 elements every time.
    // Space Complexity: O(2 * no. of the quadruplets) as we are using a set data structure and a list to store the quads.


    // better appraoch
    public static List<List<Integer>> quadrupletBetterApp(int[] arr,int target){
        int n =arr.length;
        Set<List<Integer>> ans = new HashSet<>();

        // checking all the possible quadruplets
        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                Set<Long> hashset = new HashSet<>();
                for(int k = j+1;k<n;k++){
                    // taking bigger data type to avoid integer overflow
                    long sum = arr[i] + arr[j] + arr[k];
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int) fourth);
                      // ** in Java is using the sort method to sort a List of integers (temp) in ascending order. This is achieved by specifying Integer::compareTo 
                      //  as the comparator.
                      // ** In Java, the List interface has a sort method that can be used to sort the elements of the list. The sort method requires a comparator to
                      //  determine the order of elements. The Integer::compareTo is a method reference to the compareTo method of the Integer class.
                      // ** The compareTo method is part of the Comparable interface, which is implemented by the Integer class. It compares two integers and returns 
                      // a negative value if the first integer is less than the second, zero if they are equal, and a positive value if the first integer is greater 
                      // than the second.
                        temp.sort(Integer::compareTo);
                        ans.add(temp);
                    }
                    // put the kth element in the hashset :
                    hashset.add((long) arr[k]);
                }
            }
        }
        List<List<Integer>> finalAns = new ArrayList<>(ans);
        return finalAns;
    }

    // Time Complexity:  O(N3 *  log(M)), where N = size of the array, M = no. of elements in the set. 
    //                   Reason: Here, we are mainly using 3 nested loops, and inside the loops there are some operations on the set data structure which take log(M) 
    //                          time complexity 
    // Space Complexity: O(2 * no. of the quadruplets)+O(N)
    //                   Reason: we are using a set data structure and a list to store the quads. This results in the first term. And the second space is taken by 
    //                   the set data structure we are using to store the array elements. At most, the set can contain approximately all the array elements and so 
    //                   the space complexity is O(N).
     

    //optimal approach
    public static List<List<Integer>> quadrupletOpt(int[] arr,int target){
        int n =arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array
        Arrays.sort(arr);

        // calculating the quadruplets
        for(int i=0;i<n;i++){
            // avoid the duplicates while moving i :
            if (i>0 && arr[i] == arr[i-1]) {
                continue;
            }

            for(int j=i+1;j<n;j++){
                // avoid the duplicates while moving j
                if (j>i+1 && arr[j] == arr[j-1]) {
                    continue;
                }

                // 2 pointers
                int k = j + 1;
                int l = n-1;
                while (k<l) {
                    long sum = arr[i] + arr[j] + arr[k] +arr[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        k++;
                        l--;


                        //skip the duplicates
                        while (k<l && arr[k]==arr[k-1]) {
                            k++;
                        }
                        while (k<l && arr[l]==arr[l+1]) {
                            l--;
                        }
                    }else if (sum<target) {
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    // Time Complexity:  O(N3), where N = size of the array.  Reason: Each of the pointers i and j, is running for approximately N times. And both the pointers k and l
    //                   combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N3). 
    // Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that
    //                   perspective, space complexity can be written as O(1).

    public static void main(String[] args) {
        int[] nums = {4,3,3,4,4,2,1,2,1,1};
        int target = 9;

        // List<List<Integer>> ans = quadrupletsBfa(nums, target);
        // List<List<Integer>> ans = quadrupletBetterApp(nums, target);
        List<List<Integer>> ans = quadrupletOpt(nums, target);


        for(List<Integer> it:ans){
            System.out.print("[");
            for(int ele:it){
                System.out.print(ele + " ");
            }
            System.out.print("]");
        }
        System.out.println();
    }
}
