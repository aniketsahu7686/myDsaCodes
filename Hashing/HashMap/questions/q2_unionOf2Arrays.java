package questions;

import java.util.HashSet;

public class q2_unionOf2Arrays {
    public static int  unionOf2Arr(int[] arr1,int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int j=0;j<arr2.length;j++){
            set.add(arr2[j]);
        }
        
        return set.size();
    }
    public static void main(String[] args) {
        int[] arr1 = {5,1,2,3};
        int[] arr2 = {8,1,2,4};
        System.out.println(unionOf2Arr(arr1, arr2));
    }
}


// TC : O(n) , linear time complexity
// SC : O(n) ,as we are using the hashset for storing value of arr1 and arr2