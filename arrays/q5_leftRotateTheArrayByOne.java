public class q5_leftRotateTheArrayByOne {
    public static void leftRoatateArrayByOne(int[] arr,int n){
        int temp = arr[0];   // assigning the first value to the temp 
        for(int i=0;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] =temp;  // now assigning the last value of the array to the temp 

        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }

        // TC  :  O(N)
        // SC  :  O(1) 
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 5;

        leftRoatateArrayByOne(arr, n);

    }
}
