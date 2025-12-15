import java.io.*;
import java.util.*;

public class  q9_houseRobber  {

    public static int houseRobber(int[] arr,int n){
        if(n<2){
            return arr[0];
        }
        
        int prev2 = arr[0];
        int prev1 = Math.max(arr[0],arr[1]);
        int curr = 0;
        
        for(int i=2;i<n;i++){
            curr = Math.max(prev2 + arr[i],prev1);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        int ans = houseRobber(arr,n);
        System.out.println(ans);
    }
}


// TC : O(N);
// SC : O(1)