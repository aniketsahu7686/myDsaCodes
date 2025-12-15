import java.util.ArrayList;
import java.util.HashSet;

public class q8_unionOfTwoSortedArrays {
    // brute force approach
    public static ArrayList<Integer> unionOfArraysBf(int[] arr1,int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        for(int ij:set){
            list.add(ij);
        }
        return list;
    }

    // TC :  O( (m+n)log(m+n) ) . Inserting an element in a set takes logN time, where N is no of elements in the set. At max set can
    // store m+n elements {when there are no common elements and elements in arr,arr2 are distntict}. So Inserting m+n th element
    // takes log(m+n) time. Upon approximation across inserting all elements in worst, it would take O((m+n)log(m+n) time.
    // Using HashSet also takes the same time, On average insertion in unordered_set takes O(1) time but sorting the union vector
    // takes O((m+n)log(m+n))  time. Because at max union vector can have m+n elements.

    // SC : Using HashSet also takes the same time, On average insertion in unordered_set takes O(1) time but sorting the union vector
    // takes O((m+n)log(m+n))  time. Because at max union vector can have m+n elements.


    // optimal approach 
    public static ArrayList<Integer> unionOfArraysOpt(int[] arr1,int[] arr2){
        int n = arr1.length , m = arr2.length;
        // assign two pointers 
        int i = 0 , j=0; 
        ArrayList<Integer> listt = new ArrayList<>();
        while (i<n && j<m) {
        // when arr1[i]<arr[j]
        if (arr1[i]<=arr2[j]) {
            if (listt.size()==0 || listt.get(listt.size()-1)!=arr1[i]) {
                listt.add(arr1[i]);
            }
            i++;
        }
        else{  // when arr1[i]>arr[j]
            if (listt.size()==0 || listt.get(listt.size()-1)!=arr2[j]) {
                listt.add(arr2[j]);
            }
            j++;
        }
        }
        // when  j pointer go beyond m and i pointer is left , we can say  if any element left in arr1
        while (i<n) {
            if (listt.get(listt.size()-1)!=arr1[i]) {
                listt.add(arr1[i]);
            }
            i++;
        }
        // when i pointer go beyond n and j pointer is left , we can say if any element left in arr2
        while (j<m) {
            if ( listt.get(listt.size()-1)!=arr2[j]) {
                listt.add(arr2[j]);
            }
            j++;
        }
        return listt;
    }

    // TC :  O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and
    //       all elements in arr1, arr2 are distinct. 

    // SC :  O(m+n) {If Space of Union ArrayList is considered} 

    //       O(1) {If Space of union ArrayList is not considered}      


    public static void main(String[] args){
        int[] arr1 = {1,2,2,4,5};
        int[] arr2 = {1,2,3,4,5};

        // System.out.println(unionOfArraysBf(arr1, arr2));
        System.out.println(unionOfArraysOpt(arr1, arr2));
    }
}