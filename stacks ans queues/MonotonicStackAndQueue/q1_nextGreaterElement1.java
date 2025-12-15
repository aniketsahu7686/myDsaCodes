package MonotonicStackAndQueue;

import java.util.*;
import java.util.Stack;;

public class q1_nextGreaterElement1 {

    // variation 1
    static int[] nextGreaterElementVar1(int n,int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n-1] = -1;
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
             while(st.isEmpty()==false  && st.peek()<=arr[i]){
                st.pop();
             }
             if (i<n) {
                if (st.isEmpty()==false) {
                    nge[i] = st.peek();
                }else{
                    nge[i] = -1;
                }
             }
            st.push(arr[i]);

        }
        return nge;
    }
    static int[] nextGreaterElementVar2(int n,int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for(int i=2*n-1;i>=0;i--){
             while(st.isEmpty()==false  && st.peek()<=arr[i%n]){
                st.pop();
             }
             if (i<n) {
                if (st.isEmpty()==false) {
                    nge[i] = st.peek();
                }else{
                    nge[i] = -1;
                }
             }
            st.push(arr[i%n]); 
        }
        return nge;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        // int[] ans = nextGreaterElementVar2(n,arr);
        int[] ans = nextGreaterElementVar1(n,arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
}
