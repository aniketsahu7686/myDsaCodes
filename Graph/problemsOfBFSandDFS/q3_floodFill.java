
public class q3_floodFill {
    public static void dfs(int[][] matrix,int[][] ans,int sr,int sc,int intColor,int newColor,int[] dx,int[] dy){
        int row = matrix.length;
        int col = matrix[0].length;

        ans[sr][sc] = newColor;
        for(int i=0;i<4;i++){
            int x = sr + dx[i];
            int y = sc + dy[i];

            if (x>=0 && y>=0 && x<row && y<col && ans[x][y]==intColor  && ans[x][y]!=newColor) {
                dfs(matrix, ans, x, y, intColor, newColor, dx, dy);
            }
        }
    }

    public static int[][] floodFill(int[][] matrix,int sr,int sc,int newColor){
        // here is the initial color
        int intColor = matrix[sr][sc];
        // we will store all the elements of the matrix initially in the ans , so that we not have to modify the original matrix
        int[][] ans = matrix;

        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        dfs(matrix,ans,sr,sc,intColor,newColor,dx,dy);
        return ans;

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,1,0},{1,0,1}};
        int sr =1,sc = 1;
        int newColor = 2;

        int[][] ans = floodFill(matrix,sr,sc,newColor);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// Time Complexity: O(NxM + NxMx4) ~ O(N x M)
// For the worst case, all of the pixels will have the same colour, so DFS function will be called for (N x M) nodes and for every node
// we are traversing for 4 neighbours, so it will take O(N x M x 4) time.

// Space Complexity: O(N x M) + O(N x M)
// O(N x M) for copied input array and recursive stack space takes up N x M locations at max. 