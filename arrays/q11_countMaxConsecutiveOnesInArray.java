public class q11_countMaxConsecutiveOnesInArray {
    // brute force approach
    public static int countMaxConsecOnes(int[] arr,int n){
        int count = 0;
        int max_count = 0;
         
        // we are travesing the array to check the max consecutive ones 
        for(int i=0;i<n;i++){
            if (arr[i]==1) {
                count++;
            }
            else{
                // if 0 comes between the consecutive ones
                count=0;
            }
            // max_count is to store the max consecutive ones 
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }

    // TC :  O(N) since the solution involves only a single pass.
    // SC :  O(1) because no extra space is used.

    
    public static void main(String[] args){
        int[] arr = {1,1,0,1,1,1};
        int n = 6;
        System.out.println(countMaxConsecOnes(arr, n));
    }
}
