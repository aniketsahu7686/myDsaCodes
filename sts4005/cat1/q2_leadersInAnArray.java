package cat1;
// Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on
// its right side in the array.
// here the leaders means everything in the right should be smaller

//  arr[] = { 10,22,12,3,0,6}
//  ans -->  {22,12,6}

// so here the output should be collect all the leaders 

import java.util.*;

public class q2_leadersInAnArray {
    // Brute force

    // * In this brute force approach, we start checking all the elements from the start of the array to the end to see if an 
    // element is greater than all the elements on its right (i.e, the leader).
    // * For this, we will use nested loops where the outer loop will check for each element in the array whether it is a leader or not.
    // * The inner loop checks if there is any element to the right that is greater than the element currently traversed by the outer loop.
    // * We start by initializing the outer loop pointer to the start element and setting it as the current leader.
    // * If any element traversed is found greater than the element currently set as a leader, it will not go to the ans array
    //  and we increment the outer loop pointer by 1 and set the next element as the current leader.
    // * If we don’t find any other element to the right greater than the current element, then we push the current element to the
    //  ans array stating that is it the leader element.

    public static ArrayList<Integer> printLeadersBruteForce(int[] arr,int n){
        ArrayList<Integer> ans  = new ArrayList<>();
        // check if arr[i] is greater than all the elements in the right side
        for(int i=0;i<n;i++){
            boolean leader = true;
            for(int j=i+1;j<n;j++){
                if (arr[j]>arr[i]) {
                    // if any element found if greater than the current leader 
                    // then the curr element is not the leader
                    leader = false;
                    break;
                }
            }
            // if  curr leader is greater than all the elements and the leader is true then puch the curr element  to the arraylist
            if (leader) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }

    // TC : O(N2) , Since there are nested loops being used, at the worst case n^2 time would be consumed
    // SC : O(N) ,  There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in the worst case 


    // Optimal approach 

    // * In the above approach, we do a fresh traversal for each candidate. If we think carefully, we only want to compare the elements 
    // on the right side. So, what if we start from the last element?
    // * That is, we’ll try to remember the greatest element encountered so far and we’ll use that to decide whether a candidate
    //  is a leader or not.
    // * First, we’ll start the traversal from the right. Then, we move toward the left. Whenever we encounter a new element, we check
    //  with the greatest element obtained so far.
    // * If the current element is greater than the greatest so far, then the current element is one of the leaders and we update 
    // the greatest element.
    // * Else, we proceed with the further elements on the left. This method prints the leaders in the reverse direction of their
    //  occurrences. If we are concerned about the order, we can use an extra array or a string to order.


    public static ArrayList<Integer> printLeadersOptimalApproach(int[] arr,int n){
        ArrayList<Integer> ans = new ArrayList<>();
        // last element in an array will be always a leader so push it in the ans 
        int max = arr[n-1];
        ans.add(arr[n-1]);

        for(int i=arr[n-2];i>=0;i--){
            if (arr[i]>max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        return ans;
    }

    // TC : O(N) Since the array is traversed single time back to front, it will consume O(N) of time where N = size of the array 
    // SC : O(N) There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in the worst case 

    
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {22,12,0,3,2,6};

        // ArrayList<Integer> ans = printLeadersBruteForce(arr, n);
        // for(int i=0;i<ans.size();i++){
        //     System.out.print(ans.get(i) + " ");
        // }

        ArrayList<Integer> ans = printLeadersOptimalApproach(arr, n);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        // if any time they ask in the question about print the output in the reverse order then we can do it using the collections
        // here first we will sort the array and then reverse the array by using the Collection framework

        Collections.sort(ans,Collections.reverseOrder());
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

    }

}