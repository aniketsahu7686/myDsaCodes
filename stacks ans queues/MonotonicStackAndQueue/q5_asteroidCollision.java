package MonotonicStackAndQueue;

import java.util.*;


public class q5_asteroidCollision {
    // here arr stand for the asteroid 
    public static int[] asteroidCollision(int[] arr){
        Stack<Integer> st = new Stack<>();

        for(int val:arr){
            if(val>0){
                st.push(val);
            }else{
                while(st.size()>0 && st.peek()>0 && st.peek()<-val){ // here we taken -val beacuse -*- it will become +
                    st.pop();
                }  
                if (st.size()>0 && st.peek() == -val) {
                    st.pop();
                }else if(st.size()>0  && st.peek()>-val){
                    continue;
                }else{
                    st.push(val);
                }
            }
        }
        int[] ans = new int[st.size()];
        int i = ans.length-1;
        while (i>=0) {
            ans[i] = st.peek();
            st.pop();
            i--;
        }

        return ans;
    }

    // TC : O(n), as we have to traverse through all the asteroids once
    // SC : O(n) , as we are using a stack to store the asteroids

    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] ans = asteroidCollision(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
}
