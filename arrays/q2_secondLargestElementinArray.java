
import java.util.Arrays;

public class q2_secondLargestElementinArray {
    // brute force approach
    public static int secondLargBruteForApp(int[] arr,int n){
        Arrays.sort(arr);
        int secLar = -1;
        for(int i=n-2;i>=0;i--){
            if (arr[i]<arr[n-1]) {
                secLar = arr[i];
                break;
            }
        }
        return secLar;
    }
    // here the TC : O(NlogN) + O(N) , as we are first sorting the elements and second if required traversing the whole array once to 
    // find the second largest element in the worst case
    //          SC : (1)


    // better approach
    public static int secondLargBetterApp(int[] arr,int n){
        int max = arr[0];
        for(int i=1;i<n;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        int secLarg = arr[0];
        for(int i=1;i<n;i++){
            if (arr[i]>secLarg && arr[i]<max) {
                secLarg = arr[i];
            }
        }
        return secLarg;
    }
    // TC : O(N) + O(N) = O(2N) , as first one for finding the largest element and second one for finding the second largest element
    // SC : O(1)

    // optimal approach
    public static int secondLargOptimalApp(int[] arr,int n) {
        int largestElem = arr[0]; int secLargestElem = -1;
        for(int i=1;i<n;i++){
            if (arr[i]>largestElem) {
                secLargestElem = largestElem;
                largestElem = arr[i];
            }else if(arr[i]<largestElem && arr[i]>secLargestElem){
                secLargestElem = arr[i];
            }
        }
        return secLargestElem;
    }
    // TC : O(N) , here as we are travesing the elements only one time 
    // SC : O(1)
    public static void main(String[] args){
        int[] arr = {1,2,4,7,7,5};
        // System.out.println(secondLargBruteForApp(arr, 6));
        System.out.println(secondLargBetterApp(arr, 6));
    }
}
