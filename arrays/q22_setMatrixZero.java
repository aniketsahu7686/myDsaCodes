import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

public class q22_setMatrixZero {
    // brute force approach
    public static ArrayList<ArrayList<Integer>> zeroMatrixBf(ArrayList<ArrayList<Integer>> matrix,int n ,int m){
        // set -1 for rows ans cols that contains 0 . Don't mark any 0 as -1.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix,n,m,i);
                    markCol(matrix,n,m,j);
                }
            }
        }

        // finally , mark all -1 as 0
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        
        return matrix;
    }
    
    // set all  non-zero elements as -1 in the row i
    public static void markRow(ArrayList<ArrayList<Integer>> matrix,int n,int m,int i){
        for(int j=0;j<m;j++){
            if (matrix.get(i).get(j)!=0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    // set all non-zero elements as -1 in the column
    public static void markCol(ArrayList<ArrayList<Integer>> matrix,int n,int m,int j){
        for(int i=0;i<n;i++){
            if (matrix.get(i).get(j)!=0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    // Time Complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.  
    //                  Reason: Firstly, we are traversing the matrix to find the cells with the value 0. It takes O(N*M). Now, whenever we find any such cell 
    //                  we mark that row and column with -1. This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
    //                  Another O(N*M) is taken to mark all the cells with -1 as 0 finally.
    // Space Complexity: O(1) as we are not using any extra space.


    // better approach
    public static ArrayList<ArrayList<Integer>> zeroMatrixBetterApp(ArrayList<ArrayList<Integer>> matrix, int n,int m){
        int[] row = new int[n];
        int[] col = new int[m];

        // traverse the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row with 1;
                    row[i] = 1;

                    // mark jth index of col with 1;
                    col[j] = 1;
                }
            }
        }

        // finally  mark all (i,j) as 0 , if row[i] or col[j] is marked with 1
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (row[i]==1 || col[j]==1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    // Time Complexity:  O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    //                   Reason: We are traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.

    // Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    //                   Reason: O(N) is for using the row array and O(M) is for using the col array.


    // optimal approach
    public static ArrayList<ArrayList<Integer>> zeroMatrixOpt(ArrayList<ArrayList<Integer>> matrix,int n,int m){
        int col0 = 1;

        // step 1 : Traverse the matrix and mark the 1st row and col accordingly 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix.get(i).get(j) == 0) {
                    // mark the i-th row
                    matrix.get(i).set(0, 0);

                    // mark the j-th column 
                    if (j!=0) {
                        matrix.get(0).set(j, 0);
                    }else{
                        col0 = 0;
                    }
                }
            }
        }

        // step 2 : mark with 0 from (1,1) to (n-1 , m-1)
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if (matrix.get(i).get(j) != 0) {
                    // check for the col & row
                    if (matrix.get(i).get(0)==0 || matrix.get(0).get(j)==0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }


        // step 3 : Finally mark the 1st col & then 1st row
        if (matrix.get(0).get(0) == 0) {
            for(int j=0;j<m;j++){
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for(int i=0;i<n;i++){
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }

    // Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    //                  Reason: In this approach, we are also traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.

    // Space Complexity: O(1) as we are not using any extra space.


    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));


        int n = matrix.size();
        int m = matrix.get(0).size();

        // ArrayList<ArrayList<Integer>> ans = zeroMatrixBf(matrix, n, m);
        // ArrayList<ArrayList<Integer>> ans = zeroMatrixBetterApp(matrix, n, m);
        ArrayList<ArrayList<Integer>> ans = zeroMatrixOpt(matrix, n, m);
        


        for(ArrayList<Integer> row:ans){
            for(Integer elem:row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
