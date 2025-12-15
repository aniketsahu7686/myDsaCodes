package MonotonicStackAndQueue;
import java.util.*;

public class q9_maximalRectangel {

    // now we will create a method for finding the maximal area of 1's
    public static int maximalArea(int[][] matrix){
        int n = matrix[0].length;
        int[] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = matrix[0][i];
        }
        int area = largestArea(heights);

        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==1) {
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            area = Math.max(area, largestArea(heights));
        }
        return area;
    }
    // this is the method for finding the largest rectangle in histogram
    public static int largestArea(int[] height){
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;
        int n = height.length;
        for(int i=0;i<=n;i++){
            while (!st.isEmpty() && (i==n || height[st.peek()]>=height[i])) {
                int  tempHeight = height[st.peek()];
                st.pop();

                int width;
                if(st.empty()){
                    width = i;
                }else{
                    width = i - st.peek() - 1;  // here i is the rightsmaller and st.peek() is the left smaller 
                }
                maxArea = Math.max(maxArea, width*tempHeight);
            }
            st.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
            arr[i][j] = sc.next();
           }
        }

        int ans = maximalArea(arr);
        System.out.println(ans);

    }    
}



// Space Complexity:
// The space complexity primarily comes from the heights array created in the maximalArea method and the stack st used in the largestArea method.
// The heights array has a space complexity of O(n), where n is the number of columns in the input matrix.
// The stack st also contributes to space complexity. In the worst case, it could contain all elements of the height array. Hence, the space complexity due to the stack is O(n).
// Therefore, the total space complexity is O(n), where n is the number of columns in the input matrix.


// Time Complexity:
// The time complexity is dominated by the maximalArea method and the largestArea method.
// In the maximalArea method:
// Constructing the heights array takes O(n), where n is the number of columns in the input matrix.
// Then, there's a loop iterating over each row of the input matrix. Within this loop:
// Updating the heights array takes O(n) time.
// Calling the largestArea method takes O(n) time.
// Hence, the overall time complexity of the maximalArea method is O(m * n), where m is the number of rows and n is the number of columns in the input matrix.
// In the largestArea method:
// The loop runs for O(n) iterations, where n is the number of elements in the height array.
// Inside the loop, operations are constant time except for the while loop.
// The while loop may iterate up to O(n) times in total across all iterations of the outer loop.
// Thus, the overall time complexity of the largestArea method is O(n).
// Therefore, the total time complexity of the code is O(m * n), where m is the number of rows and n is the number of columns in the input matrix.