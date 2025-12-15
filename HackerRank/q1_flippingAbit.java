// Longest sequence of consecutive one's after flipping a bit

import java.util.*;

public class q1_flippingAbit {
    public static int flippingAbit(int x){
        String binary = String.format("%32s",Integer.toBinaryString(x)).replace(' ','0');
        // so here we are using the sliding window(two pointer approach) to solve this question
        int left = 0 , right = 0 , max_length = 0 , flips = 0;
        int n = binary.length();
        
        while(right<n){
            if(binary.charAt(right)=='0'){
                flips++;
            }
            while(flips>1){
                if(binary.charAt(left)=='0'){
                    flips--;
                }
                left++;
            }
            
            max_length = Math.max(max_length,right-left+1);
            right++;
        }
        return max_length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        int ans = flippingAbit(x);
        System.out.println(ans);

        sc.close();
        
    }
}