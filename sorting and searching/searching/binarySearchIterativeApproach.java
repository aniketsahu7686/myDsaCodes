public class binarySearchIterativeApproach {
    public static int binarySearch(int[] arr,int x){
        int first = 0,end = arr.length;
        while (first<=end){
            int mid = first + (end-first)/2;

            if (arr[mid]==x){
                return mid;
            }else if (arr[mid]<x){
                first= mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,10,12};
       
        
    }
}
