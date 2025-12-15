import java.util.Scanner;

public class q2_trapRainWater {
    public static int trapWater(int[] height,int n){
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while (left<=right) {
           if (height[left]<=height[right]) {
            if (leftMax<=height[left]) {
                leftMax  = height[left];
            }else{
                ans += leftMax-height[left];
            }
            left++;
           }
           else{
            if (rightMax<=height[right]) {
                rightMax  = height[right];
            }else{
                ans += rightMax-height[right];
            }
            right--;
           }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(trapWater(arr, n));
    }
}
