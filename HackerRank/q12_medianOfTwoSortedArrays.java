
import java.sql.Time;
import java.util.*;

public class q12_medianOfTwoSortedArrays {

    // bruteforceApproach
    public static double medianOfSortedArrayBfa(int[] arr1,int[] arr2){
        int n = arr1.length;
        int m = arr2.length;

        List<Integer> arr3 = new ArrayList<>();

        int i=0, j=0 ;

        while(i<n && j<m){
            if ((arr1[i]<arr2[j])) {
                arr3.add(arr1[i]);
                i++;
            }else{
                arr3.add(arr2[j]);
                j++;
            }
        }

        // these is for the left off elements
        while(i<n){
            arr3.add(arr1[i++]);
        }
        while(j<m){
            arr3.add(arr2[j++]);
        }

        // length of the third array
        int totalArrlen = n + m;

        if(totalArrlen%2==1){
            return (double) arr3.get(totalArrlen/2);
        }
        
       double median =  ( (double) arr3.get(totalArrlen/2) + (double) arr3.get((totalArrlen/2)-1)) /2.0;
       return median;
    }

    // Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    //  Reason: We traverse through both arrays linearly.

    // Space Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    // Reason: We are using an extra array of size (n1+n2) to solve this problem.


    // better approach
    public static double medianOfSortedArrayBF(int[] arr1,int[] arr2){
        int n = arr1.length;
        int m = arr2.length;

        int totalLen = n+m;
        int ind1 = totalLen/2;
        int ind2 = ind1-1;
        int med1 = -1, med2 = -1;
        int cnt = 0;
        int i=0,j=0;

        while (i<n && j<m) {
            if (arr1[i]<arr2[j]) {
                if (cnt==ind1) {
                    med1 = arr1[i];
                }
                if(cnt==ind2){
                    med2 = arr1[i];
                }
                i++;
                cnt++;
            }else{
                if (cnt==ind1) {
                    med1 = arr2[j];
                }
                if(cnt==ind2){
                    med2 = arr2[j];
                }
                j++;
                cnt++;
            }
        }
        while (i<n) {
            if(cnt==ind1) {
                med1 = arr1[i];
            }
            if(cnt==ind2){
                med2 = arr1[i];
            }
            i++;
            cnt++;
        }
        while(j<m){
            if (cnt==ind1) {
                med1 = arr2[j];
            }
            if(cnt==ind2){
                med2 = arr2[j];
            }
            j++;
            cnt++;
        }

        if (totalLen%2==1) {
            return (double) med1;
        }

        return (double) (med1+med2)/2.0;
    }

    // Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    // Reason: We traverse through both arrays linearly.

    // Space Complexity: O(1), as we are not using any extra space to solve this problem.

    // optimal solution
    public static double medianOfSortedArrayOpt(int[] arr1,int[] arr2){
        int n = arr1.length;
        int m = arr2.length;

        if (n>m) {
            return medianOfSortedArrayBF(arr2, arr1);
        }

        // total length 
        int totalLen = n + m;

        // length of the left half
        int left = ( n + m + 1)/ 2;

        // binary search
        int low = 0 , high = n;

        while (low<=high) {
            int mid1 = (low+high)/2;
            int mid2 = left - mid1;

            // calculate l1 , l2 , r1 , r2
            int l1 = (mid1>0) ? arr1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2>0) ? arr2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1<n) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2<m) ? arr1[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (totalLen%2==1) {
                    return Math.max(l1, l2);
                }else{
                    return  (double) ( Math.max(l1, l2) + Math.min(r1, r2) ) / 2.0;
                }
            }else if (l1>r2) {
                high = mid1-1;
            }else{
                low = mid1 + 1;
            }
        }
        return -1;
    }

    // Time Complexity: O(log(min(n1,n2))), where n1 and n2 are the sizes of two given arrays.
    // Reason: We are applying binary search on the range [0, min(n1, n2)].

    // Space Complexity: O(1) as no extra space is used.


    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        // System.out.println("The median of two sorted arrays is " + medianOfSortedArrayBfa(a, b));
        // System.out.println("The median of two sorted arrays is " + medianOfSortedArrayBF(a, b));
        System.out.println("The median of two sorted arrays is " + medianOfSortedArrayOpt(a, b));
    }
}


