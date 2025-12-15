import java.util.*;

// Array contain only unquie elememts 
class searchElementInSortAndRota{
    public static int searchElement(ArrayList<Integer> arr,int n,int target){
        int low = 0,high = n - 1;
        while(low<=high){
            int mid = low + (high-low)/2;


            //if mid points to the target
            if(arr.get(mid)==target){
                return mid;
            }


            //if left part is sorted
            if(arr.get(low)<=arr.get(mid)){
                if(arr.get(low)<=target && target<= arr.get(mid)){
                    //element exists
                    high = mid - 1;
                }else{
                    // element does not exist
                    low = mid + 1;
                }
            }
            else{ // if right part is sorted
                if(arr.get(mid)<=target && target<=arr.get(high)){
                    //element exists
                    low = mid + 1;
                }else{
                    //elements does not exist
                    high = mid - 1;
                }
            }
        }
        return - 1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = 9, k = 1;
        int ans = searchElement(arr, n, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}