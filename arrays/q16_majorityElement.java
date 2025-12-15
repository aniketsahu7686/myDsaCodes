import java.sql.Time;
import java.util.HashMap;
import java.util.Map;


// Find the Majority Element that occurs more than N/2 times


public class q16_majorityElement {
    // brute force approach
    public static int majorityElementbf(int[] arr,int n){
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j = 0;j<n;j++){
                // counting the frequency of arr[j]
                if (arr[i]==arr[j]) {
                    cnt++;
                }
            }

            // check if the frequency(cnt) is equal to n/2
            if (cnt>n/2) {
                return arr[i];
            }
        }
        return -1;
    }

    // Time Complexity: O(N2), where N = size of the given array. Reason: For every element of the array the inner loop runs for
    //                  N times. And there are N elements in the array. So, the total time complexity is O(N2).
    // Space Complexity: O(1) as we use no extra space.


    // better approach
    public static int majorityElementbetterApp(int[] arr,int n){
        // declaring the map
        HashMap<Integer,Integer> map = new HashMap<>();


        // storing the map according to its occurence
        for(int i=0;i<n;i++){
            // getOrDefault return the value previously stored if it is not there then it will return 0
            int value = map.getOrDefault(arr[i],0);
            map.put(arr[i], value+1);
        }

        // searching for the majority elements
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if (it.getValue()>n/2) {
                return it.getKey();
            }
        }
        return -1;
    }

    // Time Complexity:O(N*logN) + O(N), where N = size of the given array. Reason: We are using a map data structure.
    //                 Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first
    //                 term O(N*logN). The second O(N) is for checking which element occurs more than floor(N/2) times.
    //                 If we use unordered_map instead, the first term will be O(N) for the best and average case and for
    //                 the worst case, it will be O(N2).
    // Space Complexity: O(N) as we are using a map data structure.


    //optimal approach  (Moore's voting algorithm)

    // just read (main in notes)
    // If the array contains a majority element, its occurrence must be greater than the floor(N/2). Now, we can say that the count of
    //  minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we 
    //  try to keep track of the count of elements and the element itself for which we are tracking the count. 
    //  After traversing the whole array, we will check the element stored in the variable. If the question states that the array must 
    //  contain a majority element, the stored element will be that one but if the question does not state so, then we need to check if
    //  the stored element is the majority element or not. If not, then the array does not contain any majority element.

    public static int majorityElementopt(int[] arr,int n){
        int cnt = 0;
        int element = 0;

        // applying the algorithm
        for(int i=0;i<n;i++){
            if (cnt==0) {
                cnt = 1;
                element = arr[i];
            }else if (element==arr[i]) {
                cnt++;
            }else{
                cnt--;
            }
        }

        // checking if the stored element is the majority element 
        int anothercnt = 0;
        for(int i=0;i<n;i++){
            if (arr[i]==element) {
                anothercnt++;
            }
        }

        if (anothercnt>(n/2)) {
            return element;
        }

        return -1;
    }


    // Time Complexity: O(N) + O(N), where N = size of the given array. 
    //                 Reason: The first O(N) is to calculate the count and find the expected majority element. The second one is
    //                 to check if the expected element is the majority one or not. Note: If the question states that the array
    //                 must contain a majority element, in that case, we do not need the second check. Then the time complexity
    //                 will boil down to O(N).
    // Space Complexity: O(1) as we are not using any extra space.


    public static void main(String[] args){
        int[] arr = {2,2,1,1,1,2,2};
        int ans = majorityElementbf(arr, 7);
        System.out.println(ans);
    }
}
