import java.util.HashSet;

public class q4_removeDuplicatesFromSortArray {
    // Brute force Approach , store the elements in the HashSet
    public static int removeDuplicatesBf(int[] arr,int n){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }

        int x = set.size();
        int k = 0;
        // again store the elements from the first without duplicating it
        for(int z:set){
            arr[k++] = z;
        }
        return k;
    }
    // TC : O(NlogN) + O(N) ,as NlogN for inserting the elements in the Hashset and O(N) again to make an array without duplicate 
    //      elements
    // SC : O(N) , as we are using the Hashset for storing the elements




    // Optimal approach (Two Pointer Approach)
    // Take a variable i as 0;
    // Use a for loop by using a variable ‘j’ from 1 to length of the array.
    // If arr[j] != arr[i], increase ‘i’ and update arr[i] == arr[j].
    // After completion of the loop return i+1, i.e size of the array of unique elements.
    
    public static int removeDuplicatesOpt(int[] arr,int n){
        int i = 0;
        for(int j=1;j<n;j++){
            if (arr[i]!=arr[j]) {
                // point the i to i++ , then  assign its value to arr[j]
                i++;
                arr[i] = arr[j]; 
            }
        }
        return i+1;
    }

    // TC : O(N) ,as we are traversing the elements only once
    // SC : o(1)

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,3};
        // int k = removeDuplicatesBf(arr, 7);
        int k = removeDuplicatesOpt(arr, 7);
        for(int i=0;i<k;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
