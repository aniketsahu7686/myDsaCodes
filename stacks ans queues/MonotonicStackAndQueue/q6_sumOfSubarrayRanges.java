package MonotonicStackAndQueue;

import java.util.Scanner;

public class q6_sumOfSubarrayRanges {
    public static int sumOfSubArr(int[] arr){
        int n = arr.length;
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int max = Math.max(arr[i], arr[j]);
                int min = Math.min(arr[i], arr[j]);
                result += max-min;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int ans  = sumOfSubArr(arr);
        System.out.println(ans);
    }

  
}
