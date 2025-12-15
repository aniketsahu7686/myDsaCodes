import java.sql.Time;

public class q23_rotateImageBy90Degree {
    // brute force approach
    public static int[][] rotateBFA(int[][] matrix){
        int n = matrix.length;
        int rotated[][] = new int[n][n];


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotated[j][n-i-1] = matrix[i][j];
            }
        }

        return rotated;
    }

    // Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.
    // Space Complexity: O(N*N) to copy it into some other matrix.


    // optimal approach

    //first we will transpose the matrix
    public static void transpose(int[][] matrix){
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


     //  then we will reverse each row
    public static int[][] rotateOptimalApproach(int[][] matrix){
        transpose(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }

        return matrix;

    }

    // Time Complexity: O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix.
    // Space Complexity: O(1).


    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{4,5,6,3},{7,8,9,5},{10,11,12,13}};
        // int rotated[][] = rotateBFA(arr);
        int rotated[][] = rotateOptimalApproach(arr);

        for(int i=0;i<rotated.length;i++){
            for(int j=0;j<rotated.length;j++){
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
