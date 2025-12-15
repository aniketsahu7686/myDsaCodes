import java.sql.Time;
import java.util.Arrays;

public class q32_mergeTwoSortedArrays {
    // brute force approach 
    public static void mergeTwoSortedArrBfa(long[] arr1,long[] arr2,int n,int m){
        // declare  a 3rd array and 2 pointers :
        long[] arr3 = new long[n + m];

        int left = 0;
        int right = 0;
        int index = 0;


        // insert the elements from the 2 arrays into the 3rd array using left and right pointers :
        while (left<n && right<m) {
            if (arr1[left]<arr2[right]) {
                arr3[index] = arr1[left];
                left++;
                index++;
            }else{
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }


        // if the right pointer reaches the end :
        while (left<n) {
            arr3[index++] = arr1[left++];
        }

        // if right pointer reaches the end :
        while (right<m) {
            arr3[index++] = arr2[right++];
        }


        // fill back the elements from arr3[] to arr1[] and arr2[]
        for(int i=0;i<n+m;i++){
            if (i<n) {
                arr1[i] = arr3[i];
            }else{
                arr2[i-n] = arr3[i];
            }
        }
    }


// Time Complexity: O(n+m) + O(n+m), where n and m are the sizes of the given arrays. Reason: O(n+m) is for copying the elements from arr1[] and arr2[] to arr3[].
//                  And another O(n+m) is for filling back the two given arrays from arr3[].
// Space Complexity: O(n+m) as we use an extra array of size n+m.

// optimal approach
public static void mergeTwoSortedArrOpt(long[] arr1,long[] arr2,int n,int m){
    // declare the two pointers
    int left = n-1;
    int right = 0;

    // as both the arrays are in  non decreasing order 
    // swap the elements until arr1[left] is smaller than the arr2[right]
    while (left>=0 && right<m) {
        if (arr1[left]>arr2[right]) {
            long temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
            left--;
            right++;
        }else{
            break;
        }
    }

    // sort the arr1[] and arr2[] individually
    Arrays.sort(arr1);
    Arrays.sort(arr2);
}

    public static void main(String[] args) {
        long[] arr1 = {1,4,8,10};
        long[] arr2 = {2,3,9};

        int n = 7,m = 3;
        // mergeTwoSortedArrBfa(arr1, arr2, n, m);
        mergeTwoSortedArrOpt(arr1, arr2, n, m);
        System.out.print("arr1[] = ");
        for(int i=0;i<n;i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.print("arr2[] = ");
        for(int i=0;i<m;i++){
            System.out.print(arr2[i] + " ");
        }
    }
}