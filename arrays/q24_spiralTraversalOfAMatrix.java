import java.sql.Time;
import java.util.*;

public class q24_spiralTraversalOfAMatrix {
    // brute force approach
    public static List<Integer> printSpiral(int[][] arr){

        // Define ans list to store the result
        List<Integer> ans = new ArrayList<>();

        // no of rows
        int n = arr.length;

        // no of columns
        int m = arr[0].length;


        // initialize the pointers required for traversal
        int top = 0, left = 0,bottom = n-1 , right = m -1;

        // loop until all elements are not traversed
        while (top<=bottom  && left<=right) {

            // for moving left to right
            for(int i=left;i<=right;i++){
                ans.add(arr[top][i]);
            }
            top++;

            // for moving top to bottom
            for(int i=top;i<=bottom;i++){
                ans.add(arr[i][right]);
            }
            right--;

            // for moving right to left
            if (top<=bottom) {
                for(int i=right;i>=left;i--){
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }

            // for moving bottom to top
            if (left<=right) {
                for(int i=bottom;i>=top;i--){
                    ans.add(arr[i][left]);
                }

                left++;
            }
        }
        return ans;
    }

    // Time Complexity:  O(m x n) { Since all the elements are being traversed once and there are total n x m elements ( m elements in each row and total n rows) so the
    //                   time complexity will be O(n x m)}.
                     
    // Space Complexity: O(n) { Extra Space used for storing traversal in the ans array }.

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        List<Integer> ans = printSpiral(matrix);

        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
