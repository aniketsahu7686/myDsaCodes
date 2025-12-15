import java.sql.Time;
import java.util.*;

public class q27_majorityElement {
    // Find the elements that appears more than N/3 times in the array

    // brute force approach
    public static List<Integer>  majorityElementBf(int[] arr){
        int n = arr.length;
        // list of the answers
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            // selected element is arr[i] , checking if arr[i] is not already a part of the answer
            if (list.size() == 0  || list.get(0)!=arr[i]) {
                int cnt = 0;

                for(int j=0;j<n;j++){
                    // counting the frequecny of arr[i]
                    if (arr[i]==arr[j]) {
                        cnt++;
                    }
                }

                // check if the frequency is greater than n/3
                if (cnt>(n/3)) {
                    list.add(arr[i]);
                }
            }

            if (list.size()==2) {
                break;
            }
        }
        return list;
    }

    // Time Complexity: O(N2), where N = size of the given array.  Reason: For every element of the array the inner loop runs for N times. And there are N elements
    //                  in the array. So, the total time complexity is O(N2).
    // Space Complexity: O(1) as we are using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constant.

    // better approach
    public static List<Integer> majorityElementBetterApp(int[] arr){
        int n =arr.length;
        // list of the answers
        List<Integer> list = new ArrayList<>();

        // declaring a map
        HashMap<Integer,Integer> map = new HashMap<>();

        // least occurence of the majority element 
        int mini = (int)  (n/3) + 1;

        // storing the elemtent with its occurence
        for(int i=0;i<n;i++){
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value+1);

            // checking if arr[i] is the majority element
            if (map.get(arr[i])==mini) {
                list.add(arr[i]);
            }
            if (list.size()==2) {
                break;
            }
        }
        return list;
    }

    // Time Complexity: O(N*logN), where N = size of the given array.
    //                  Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the 
    //                  first term O(N*logN).
    //                  If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).
    // Space Complexity:O(N) as we are using a map data structure. We are also using a list that stores a maximum of 2 elements. That space used is so small that
    //                  it can be considered constant.

    // optimal approach
    public static List<Integer> majorityElementOpt(int[] arr){
        int n = arr.length;

        // counts
        int cnt1 = 0,cnt2 = 0;
        // element 1
        int elem1 = Integer.MIN_VALUE;
        // element 2
        int elem2 = Integer.MIN_VALUE;

        // here we will apply the Extended Boyer Moore's Voting Algorithms
        for(int i=0;i<n;i++){
            if (cnt1 == 0 && elem2!=arr[i]) {
                cnt1 = 1;
                elem1 = arr[i];
            }else if (cnt2 == 0 && elem1!=arr[i]) {
                cnt2 = 1;
                elem2 = arr[i];
            }else if (arr[i]==elem1) {
                cnt1++;
            }else if (arr[i]==elem2) {
                cnt2++;
            }else{
                cnt1--; cnt2--;
            }
        }

        // list of the answers
        List<Integer> list = new ArrayList<>();

        // Manually check if the stored elements in elem1 and elem2 are the majority elements
         cnt1 = 0; cnt2 = 0;

         for(int i=0;i<n;i++){
                if (arr[i]==elem1) {
                    cnt1++;
                }if (arr[i]==elem2) {
                    cnt2++;
                }
         }

         int mini = (int) (n/3) + 1;
         if (cnt1>=mini) {
            list.add(elem1);
         }
         if (cnt2>=mini) {
            list.add(elem2);
         }

         // Uncomment the following line if it is told to sort the answer array:
         // Collections.sort(ls)  --> leads to TC: O(2*log2) ~ O(1)
         
         return list;
    }

//     Time Complexity:    O(N) + O(N), where N = size of the given array.
//                         Reason: The first O(N) is to calculate the counts and find the expected majority elements. The second one is to check if the calculated
//                         elements are the majority ones or not.
//    Space Complexity:    O(1) as we are only using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constant.


    public static void main(String[] args) {
        int[] arr = {11,33,33,11,33,11};
        // List<Integer> ans = majorityElementBf(arr);
        List<Integer> ans = majorityElementBetterApp(arr);
        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
