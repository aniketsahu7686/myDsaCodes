package questions;

import java.util.HashSet;

public class q3_intersectionOf2Arrays {
    public static int intersectionOf2Arr(int[] arr1,int[] arr2){
        // step 1 : create the hashset
        HashSet<Integer> set  = new HashSet<>();
        int count = 0;
        // first add the elements
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        // then check the elements of the arr2 if it is contains in the hashset or not
        for(int j=0;j<arr2.length;j++){
            if (set.contains(arr2[j])) {
                // if it contains increment the count
                count++;
                // and remove it so that no duplicates elements can intersect with it
                set.remove(arr2[j]);
            }
        }
        // return the frequency of the intersection as the count
        return count;
    }
    public static void main(String[] args) {
        int[] arr1 = {5,1,2,3};
        int[] arr2 = {8,1,2,4};
        System.out.println(intersectionOf2Arr(arr1, arr2));
    }
}
