import java.util.ArrayList;

public class q7_moveAllZeroToTheEnd {

    // brute force Approach
    public static int[] moveAllTheZeroToEndBf(int[] arr,int n){
        // temporary array
        ArrayList<Integer> temp = new ArrayList<>();

        // copy all the non-zero elements from the orginal -> temp array
        for(int i=0;i<n;i++){
            if (arr[i]!=0) {
                temp.add(arr[i]);
            }
        }

        // no of (nz) non-zero elements
        int nz = temp.size();

        // copy elements from temp
        // fill first nz fields of original array

        for(int i=0;i<nz;i++){
            arr[i] = temp.get(i);
        }

        // fill rest of the cells with 0;
        for(int i=nz;i<n;i++){
            arr[i] = 0;
        }

        return arr;
    }

    // TC : O(2N) ,  O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array.
    //  O(N-X) for filling zeros in the original array. So, the total time complexity will be O(2*N).

    // SC : O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array. O(N-X)
    //  for filling zeros in the original array. So, the total time complexity will be O(2*N).The temporary array stores the non-zero elements. In the worst case, all 
    //  the given array elements will be non-zero.

    // optimal approach
    public static int[] moveZeroesToTheEndOpt(int[] arr,int n){
        int j = -1;
        // place the position of the pointer j 
        for(int i=0;i<n;i++){
            if (arr[i]==0) {
                j = i;
                break;
            }
        }

        // no non-zero elements
        if(j==-1) return arr;

        // move the pointers i and j and swap accordingly
        for(int i = j+1;i<n;i++){
            if (arr[i]!=0) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
        return arr;
    }

    // TC :  O(N), N = size of the array. Reason: We have used 2 loops and using those loops, we are basically traversing the array once.
    // SC :  O(1) as we are not using any extra space to solve this problem. 


    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        int n =10;
        int[] ans = moveAllTheZeroToEndBf(arr, n);
        // int[] ans = moveZeroesToTheEndOpt(arr, n);
        for(int i=0;i<n;i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println(" ");
    }
}
