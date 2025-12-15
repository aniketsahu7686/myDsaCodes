public class q9_noOfIslands {
    public static void dfs(int row,int col,int[][] visited,int[][] arr,int[] dx,int[] dy){
        int n = arr.length;
        int m = arr[0].length;


        visited[row][col] = 1;

        for(int i=0;i<4;i++){
            int x = row + dx[i];
            int y = col + dy[i];

            if (x>=0 && y>=0 && x<n && y<m && arr[x][y]==1 && visited[x][y]==0) {
                dfs(x,y,visited,arr,dx,dy);
            }
        }
    }
    public static int noOfIslands(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;

        int count = 0;
        int[][] visited = new int[row][col];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (arr[i][j]==1 && visited[i][j]==0) {
                    count++;
                    dfs(i,j,visited,arr,dx,dy);
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        // int[][] arr = {{0,1,1,0},{0,1,1,0},{0,0,1,0},{0,0,0,0},{1,1,0,1}};
        int[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int ans = noOfIslands(arr);
        System.out.println(ans);
    }
}
  

// we can also do this using the bfs as same process

// Time Complexity ~ O(N² + NxMx9), N² for the nested loops, and NxMx9 for the overall DFS of the matrix, that will happen throughout 
//                   if all the cells are filled with 1.

// Space Complexity: O(N²) for visited array max queue space O(N²), If all are marked as 1 then the maximum queue space will be N².