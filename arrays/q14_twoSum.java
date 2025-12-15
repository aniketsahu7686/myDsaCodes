import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;

public class q14_twoSum {
    // here the question is check if a pair with given sum exists in array 
    // brute force approach 

    // 1st variant 
    public static String twoSumBf1St(int[] arr,int target){
        for(int i=0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                int sum = arr[i] + arr[j];
                if (sum==target) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    // TC : O(N2), where N = size of the array. Reason: There are two loops(i.e. nested) each running for approximately N times.
    // SC :  O(1) as we are not using any extra space.



    // 2nd variant
    public static int[] twoSumBf2nd(int[] arr,int target){
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i] + arr[j];
                if (sum ==target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    // TC : O(N2), where N = size of the array. Reason: There are two loops(i.e. nested) each running for approximately N times.
    // SC : O(1) as we are not using any extra space.


    // better approach

    // 1St variant 
    public static String twoSumBetterApp1st(int[] arr,int target){
        // here we are assigning the hashmap 
        HashMap<Integer,Integer> map = new HashMap<>();
        // we are iteraing the loop 
        for(int i=0;i<arr.length;i++){
            // intialize the value of num as starting value of the array
            int num = arr[i];
            // by subtracting the num from the target we get the remaining element we still needed 
            int stillNeeded = target - num;
            // if the remaining element still contains in the map return yes
            if (map.containsKey(stillNeeded)) {
                return "Yes";
            }
            // or else add it to the map 
            map.put(arr[i], i);
        }
        return "No";
    }

    // TC: O(N), where N = size of the array. Reason: The loop runs N times in the worst case and searching in a hashmap takes 
    // O(1) generally. So the time complexity is O(N).
    // Note: In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the 
    // time complexity will be O(N2). If we use map instead of unordered_map, the time complexity will be O(N* logN) as the
    //  map data structure takes logN time to find an element.
    
    
    // SC: O(N) as we use the map data structure.
    // Note: We have optimized this problem enough. But if in the interview, we are not allowed to use the map data structure,
    // then we should move on to the following approach i.e. two pointer approach. This approach will have the same time complexity 
    // as the better approach.



    // 2nd variant
    public static int[] twoSumBetterApp2nd(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            int stillNeeded = target - num;
            if (map.containsKey(stillNeeded)) {
                // if the remaining element is found then we assigning the value of its key to ans[0]
                ans[0] = map.get(stillNeeded);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i], i);
        }
        return ans;
    }

    // TC: O(N), where N = size of the array. Reason: The loop runs N times in the worst case and searching in a hashmap takes 
    // O(1) generally. So the time complexity is O(N).
    // Note: In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the 
    // time complexity will be O(N2). If we use map instead of unordered_map, the time complexity will be O(N* logN) as the
    //  map data structure takes logN time to find an element.
    
    
    // SC: O(N) as we use the map data structure.
    // Note: We have optimized this problem enough. But if in the interview, we are not allowed to use the map data structure,
    // then we should move on to the following approach i.e. two pointer approach. This approach will have the same time complexity 
    // as the better approach.




    // optimal appraoch
    
    // 1st variant
    public static String twoSumOptimalApp(int[] arr,int target){
        Arrays.sort(arr);
        int left = 0,right = arr.length-1;
        while (left<right) {
            int sum = arr[left] + arr[right];
            if (sum==target) {
                return "YES";
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return "NO";
    }
    // TC : O(N) + O(N*logN), where N = size of the array. Reason: The loop will run at most N times. And sorting the array will
    //  take N*logN time complexity.
    // SC : O(1) as we are not using any extra space.

    // 2nd variant 
    // for the variant 2 the recommened approach is  the appraoch 2 if we want to optimize the time complexity otherwise 
    // use this approach 
    public static int[] twoSumOptimalApp2ndVar(int[] arr,int target){
        Arrays.sort(arr);
        int left = 0,right = arr.length-1;
        int[] ans = new int[2];
        while (left<right) {
            int sum = arr[left] + arr[right];
            if (sum==target) {
                ans[0] = arr[left];
                ans[1] = arr[right];
                break;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;

        //bfa 1variant
        // System.out.println(twoSumBf1St(arr, target));

        // bfa 2ndvariant
        // int[] ans = twoSumBf2nd(arr, target);
        // System.out.println("ans is " + "[" + ans[0] + "," + ans[1] + "]");


        // better app 1st variant
        // System.out.println(twoSumBetterApp1st(arr, target));

        // better app 2nd variant
        //  int[] ans = twoSumBetterApp2nd(arr, target);
        // System.out.println("ans is " + "[" + ans[0] + "," + ans[1] + "]");

        // optimal approach
        // System.out.println(twoSumOptimalApp(arr, target));
        int[] ans = twoSumOptimalApp2ndVar(arr,target);
        System.out.println(ans[0] + " " + ans[1]);




    }
}
