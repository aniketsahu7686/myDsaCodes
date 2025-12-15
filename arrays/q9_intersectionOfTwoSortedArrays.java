import java.util.*;
public class q9_intersectionOfTwoSortedArrays {
    // brute force approach
    public static ArrayList<Integer> intersectionOfTwoSortedArraysBf(int[] arr1,int[] arr2){
        ArrayList<Integer> list = new ArrayList<>();

        // to make sure the elements of the arr2 are visited or not
        int[] visited = new int[arr2.length];
        
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if (arr1[i]==arr2[j] && visited[j]==0) {
                    //if element matches and has not been matched with any other before
                    list.add(arr2[j]);
                    visited[j] = 1;

                    break;
                }else if (arr2[j]>arr1[i]) {  //as array is sorted and element will not be beyond this
                    break;
                }
            }
        }
        return list;
    }


    // TC : O(n1 x n2) ~ O(n^2) { There are nested loops where the outer one loops n1 times and the inner one loops n2 times,
    //      where n1 = A.size() and n2 = B.size() }.
    // SC : O(n) { Extra Space used for the visited and ans arrays }.


    //optimal approach
    public static ArrayList<Integer>  intersectionOfTwoSortedArraysOpt(int[] arr1,int[] arr2){
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i]<arr2[j]) {
                i++;
            }else if (arr1[i]>arr2[j]) {
                j++;
            }else{
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }

    // TC : O(n) { Since the elements are compared within the single pass for both the arrays this approach would take a linear
    //      time and in the worst case O(n1+n2) to store ans and return  where n1 = A.size() and n2 = B.size() }.
    // SC : O(1) { There is no extra space used in the two-pointers approach }.


    public static void main(String[] args){
        int[] arr1  = {1,2,2,3,4,5,7};
        int[] arr2 = {1,2,2,3,4,5,6,7};

        // System.out.println(intersectionOfTwoSortedArraysBf(arr1, arr2));
        System.out.println(intersectionOfTwoSortedArraysOpt(arr1, arr2));


    }
}
