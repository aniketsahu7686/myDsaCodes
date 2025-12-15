import java.util.*;

public class q11_maxNoOfSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;

        while(start<end){
            int temp = nums[start]+nums[end];
            if(temp==k){
                count++;
                start++;
                end--;
            }else if(temp<k){
                start++;
            }else{
                end--;
            }
        }

        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
    }
}