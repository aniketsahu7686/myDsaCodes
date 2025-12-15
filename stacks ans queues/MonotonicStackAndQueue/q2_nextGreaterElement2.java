package MonotonicStackAndQueue;

import java.util.*;

public class q2_nextGreaterElement2 {
    static int[] nextGreaterElement(int[] nums1,int[] nums2){
        int[]  nge = ngeForStoringInHashMap( nums2);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], nge[i]);
        }

        int[] finalans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            finalans[i] = map.get(nums1[i]);
        }

        return finalans;
    }
    static int[] ngeForStoringInHashMap(int[] nums2){
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        ans[n-1] = -1;
        st.push(nums2[n-1]);
        for(int i=n-2;i>=0;i--){
             while(st.isEmpty()==false  && st.peek()<=nums2[i]){
                st.pop();
             }
             if (i<n) {
                if (st.isEmpty()==false) {
                    ans[i] = st.peek();
                }else{
                    ans[i] = -1;
                }
             }
            st.push(nums2[i]);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums1  = new int[n];
        int[] nums2 = new int[m];
        for(int i=0;i<n;i++){
            nums1[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            nums2[i] = sc.nextInt();
        }
        int[] ans = nextGreaterElement(nums1, nums2);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
}



// Time Complexity:

// The ngeForStoringInHashMap method has a time complexity of O(N), where N is the length of the nums2 array, as it iterates through the array once.
// The nextGreaterElement method iterates through the nums1 array once, and for each element, it performs a constant time operation to retrieve the corresponding next greater element from the HashMap. Therefore, its time complexity is O(M), where M is the length of the nums1 array.
// Overall, the time complexity of the code is O(N + M).




// Space Complexity:

// The space complexity of the ngeForStoringInHashMap method is O(N), where N is the length of the nums2 array. This is because it creates an array of size N to store the next greater elements.
// In the nextGreaterElement method, additional space is used to store the HashMap, which has a space complexity of O(N), where N is the length of the nums2 array.
// Apart from these, space is also used for the input arrays nums1 and nums2, which have space complexity of O(N + M).
// Therefore, the overall space complexity of the code is O(N + M).