package questions;

import java.util.HashMap;

public class q5_subArraySumEqualToK {
    public static void main(String[] args) {
        int[] arr = { 10,2,-2,-20,10}; //ans = 3
        int k = -10;

        HashMap<Integer,Integer> map = new HashMap<>();  // <Sum,Freq>

        map.put(0,1); //empty subarray whose we will store the value as 0 and its frequency to 1 as it only appear one time 

        int ans = 0;
        int sum = 0;

        // now we will run a loop 
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];

            if (map.containsKey(sum-k)) {
                ans+=map.get(sum-k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }
        System.out.println(ans);
    }

    

}
