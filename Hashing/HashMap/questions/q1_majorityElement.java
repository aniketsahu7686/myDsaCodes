package questions;

import java.util.HashMap;

public class q1_majorityElement {
    public static void majElemet(int[] nums){
        // step 1 : create the HashMap
        HashMap<Integer,Integer> map = new HashMap<>();
        

        // step 2 : find the frequency of all the elements and store it in the map 
        int n = nums.length;
        for(int i=0;i<n;i++){
            if (map.containsKey(nums[i])) { // if the key already contains then the frequency will be updated  by 1
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);  // if the key doesn't contains then the frequency will be intially 1
            }
        }

        // step 3 : 
        for(int key:map.keySet()){ // here from  map.keySet() ,we will get the whole set of the map
            if (map.get(key)> n/3) {
                System.out.print(key + " ");
            }
        }  
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,5,1,1,8,1};
        majElemet(nums); 
    }
}


// TC : O(n) , iterate all the elements one time
// SC : O(n)  , as we are using the hashmap to store the key and its value