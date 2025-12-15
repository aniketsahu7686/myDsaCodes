import java.util.*;

// surrounded Regions (Replace the 0's with 1)

public class q5_surroundedRegions {
    public static void dfs(int row,int col,int[][] visited,char[][] board,int[] dx,int[] dy){
        visited[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        // check for the top , right , bottom and left
        for(int i=0;i<4;i++){
            int x = row + dx[i];
            int y = col + dy[i];

            // check for the valid coordinates and unvisited 0's
            if (x>=0 && y>=0 && x<n && y<m && visited[row][col]==0 && board[row][col]=='O') {
                dfs(x, y, visited, board, dx, dy);
            }
        }
    }
    public static char[][] surroundedReg(char[][] board,int row,int col){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0 };

        int[][] visited = new int[row][col];

        // traverse the first row and last row
        for(int j=0;j<col;j++){
            // check for the unvisited 0's in the boundary 

            // first row
            if(visited[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,visited,board,dx,dy);
            }

            // last row
            if (visited[row-1][j]==0 && board[row-1][j]=='O') {
                dfs(row-1, j, visited, board, dx, dy);
            }
        }

        // traverse the first column and last column
        for(int i=0;i<row;i++){
             
            // first column
            if (visited[i][0]==0 && board[i][0]=='O') {
                dfs(i, 0, visited, board, dx, dy);
            }

            // last column
            if (visited[i][col-1]==0 && board[i][col-1]=='O') {
                dfs(i, col-1, visited, board, dx, dy);
            }
        }

        // if the unvisited 0 then convert it to x
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (visited[i][j]==0 && board[i][j]=='O') {
                    board[i][j] = 'X';
                }
            }
        }

        return board;
    }
    public static void main(String[] args){
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        int row = 4;
        int col = 4;

        char[][] ans = surroundedReg(board,row,col);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}



// Time Complexity: O(N) + O(M) + O(NxMx4) ~ O(N x M), For the worst case, every element will be marked as ‘O’ in the matrix,
//                  and the DFS function will be called for (N x M) nodes and for every node, we are traversing for 4 neighbors, 
//                  so it will take  O(N x M x 4) time. Also, we are running loops for boundary elements so it will take O(N) + O(M).

// Space Complexity ~ O(N x M), O(N x M) for the visited array, and auxiliary stack space takes up N x M locations at max. 