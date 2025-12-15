package MonotonicStackAndQueue;


import java.util.*;
public class q7_removeKDigits {
    public static String removeKDigits(int[] arr,int k){
       int n = arr.length;

       Stack<Integer> st = new Stack<>();

       for(int i=0;i<n;i++){
        int ch = arr[i];
        //case 1:  if a greater element is present in front of a smaller element 
        while(st.size()>0 && k>0 && st.peek()>ch){
            st.pop();
            k--;
        }
        st.push(ch);
       }

       // case 2: when the k value is still no zero means k>0
       while (st.size()>0 && k>0) {   
         st.pop();
         k--;
       }

       int remainingSize = st.size(); // Number of elements left after removing k digits
            if (remainingSize == 0) {
                return "0"; // If no elements left, return "0"
            }

            
       int[] ans = new int[st.size()];
       int x = ans.length-1;
       while (x>=0) {
        ans[x] = st.pop();
        x--;
       }

       // no we will check for the cases of cotinue zeroes in front which should not be
       int d = 0;
       while(d<ans.length && ans[d]==0){
        d++;
       }

       StringBuilder sb = new StringBuilder();
       while (d<ans.length) {
           sb.append(ans[d++]);
       }
    //    if (sb.length()==0) {
    //     sb.append(0);
    //    }
       
       return sb.toString();
   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        if (s.trim().isEmpty()) {
            System.out.println("Invalid input: Empty string");
            return;
        }
        String[] sarr = s.split("\\s+");
        int[] arr = new int[sarr.length];
            for (int i = 0; i < sarr.length; i++) {
                arr[i] = Integer.parseInt(sarr[i]);
            }
        
        String ans = removeKDigits(arr, k);
        System.out.println(ans);
    }
}