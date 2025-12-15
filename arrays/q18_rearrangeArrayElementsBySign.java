import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class q18_rearrangeArrayElementsBySign {

    // Variation 1 : same no of positve and negative elements in an array 

    // brute force approach
   public static int[] rearrangeElementsBySignBf(int[] arr,int n){
     // define two arraylist one for storing the positve elements and another for storing the negative elements
     ArrayList<Integer> pos = new ArrayList<>();
     ArrayList<Integer> neg = new ArrayList<>();


     // segregate the array into positive and negative integers
     for(int i=0;i<n;i++){
        if (arr[i]>0) {
            pos.add(arr[i]);
        }else{
            neg.add(arr[i]);
        }
     }

     // positives in even indices and negatives on odd
     for(int i=0;i<n/2;i++){
        arr[2*i] = pos.get(i);
        arr[2*i+1] = neg.get(i);
     }
     
     return arr;
   }


//    Time Complexity: O(N+N/2) { O(N) for traversing the array once for segregating positives and negatives and another O(N/2) for
//                     adding those elements alternatively to the array, where N = size of the array A}.
//    Space Complexity: O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays, where N = size 
//                      of the array A}.




    // optimal approach


    public static ArrayList<Integer> rearrangeBySignOpt(ArrayList<Integer> arr){
        int n = arr.size();

    // define array for storing the ans seperately 
        ArrayList<Integer> ans  = new ArrayList<>(Collections.nCopies(n,0));


    // postive elements start from 0 and negative from 1
        int posIndex = 0 , negIndex = 1;

        for(int i=0;i<n;i++){
        // fill all the  negative elements in odd indices and inc by 2;
            if (arr.get(i)<0) {
                ans.set(negIndex, arr.get(i));
                negIndex+=2;
            }

        // fill all the positive in even indices and inc by 2
            else{
                ans.set(posIndex, arr.get(i));
            }
        }
    return ans;
    }

    // Time Complexity: O(N) { O(N) for traversing the array once and substituting positives and negatives simultaneously using pointers,
    //                  where N = size of the array A}.
    // Space Complexity:  O(N) { Extra Space used to store the rearranged elements separately in an array, where N = size of array A}.



    // variation 2 : different no of positve and negative elements
    public static ArrayList<Integer> rearrangeBySignVar2(ArrayList<Integer> arr,int n){
          // Define 2 ArrayLists, one for storing positive  and other for negative elements of the array.
          ArrayList<Integer> pos = new ArrayList<>();
          ArrayList<Integer> neg = new ArrayList<>();


          // segregate the array into postives and negatives 
          for(int i=0;i<n;i++){
            if (arr.get(i)>0) {
                pos.add(arr.get(i));
            }else{
                neg.add(arr.get(i));
            }
          }


          // if positves are lesser than the negatives
          if (pos.size()<neg.size()) {
            
            // first fill array alternatively till the point where positives and negatives are equal in number
            for(int i=0;i<pos.size();i++){
                arr.set(2*i, pos.get(i));
                arr.set(2*i+1, neg.get(i));
            }


            // fill the remaining negatives at the end of the array 
            int index = pos.size() * 2;
            for(int i=pos.size();i<neg.size();i++){
                arr.set(index, neg.get(i));
                index++;
            }
          }

          // if negatives are lesser than positives
          else{
            // first , fill array alternatively till the point
            // where positves and negatives are equal in number

            for(int i=0;i<neg.size();i++){
                arr.set(2*i, pos.get(i));
                arr.set(2*i+1, neg.get(i));
            }

            // fill the remaining postives at the end of the array 
            int index = neg.size() * 2;
            for(int i=neg.size();i<pos.size();i++){
                arr.set(index, pos.get(i));
                index++; 
            }
          }
          return arr;
    }

    // Time Complexity : O(2*N) { The worst case complexity is O(2*N) which is a combination of O(N) of traversing the array to segregate into neg and pos array and
    //      O(N) for adding the elements alternatively to the main array}.
         
         
    //      Explanation: The second O(N) is a combination of O(min(pos, neg)) + O(leftover elements). There can be two cases: when only positive or only negative 
    //      elements are present, O(min(pos, neg)) + O(leftover) = O(0) + O(N), and when equal no. of positive and negative elements are present,
    //      O(min(pos, neg)) + O(leftover) = O(N/2) + O(0). So, from these two cases, we can say the worst-case time complexity is O(N) for the second part,
    //      and by adding the first part we get the total complexity of O(2*N).

    // Space Complexity :  O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays, where N = size of the array A}.
    

 
    public static void main(String[] args) {
    // for variation 1
    // Array Initialization.
        // ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5));
        // ArrayList<Integer> ans = rearrangeBySignOpt(A);

        // for (int i = 0; i < ans.size(); i++) {
        //     System.out.print(ans.get(i) + " ");
        // }


        // for variation 2 
        int n = 6;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        ArrayList<Integer> ans = rearrangeBySignVar2(A, n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
