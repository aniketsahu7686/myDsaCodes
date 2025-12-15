public class q6_noOfEnclaves {
    public static void dfs(int row,int col,int[][] visited,int[][] arr,int[] dx,int[] dy){
        int n = arr.length;
        int m = arr[0].length;
        visited[row][col] = 1;

        for(int i=0;i<4;i++){
            int x = row + dx[i];
            int y = col + dy[i];

            if (x>=0 && y>=0 && x<n && y<m && visited[x][y]==0 && arr[x][y]==1) {
                dfs(x, y, visited, arr, dx, dy); 
            }
        }
    }
    public static int noOfEnclaves(int[][] arr,int row,int col){

        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;  // Handling edge cases where input array is empty
        }

        int[][] visited =  new int[row][col];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};


        // first traverse the first row and last row
        for(int j=0;j<col;j++){
            // first row
            if (visited[0][j]==0 && arr[0][j]==1) {
                dfs(0,j,visited,arr,dx,dy);
            }
            // last row
            if (visited[row-1][j]==0 && arr[row-1][j]==1) {
                dfs(row-1,j, visited, arr, dx, dy);
            }
        }

        // next traverse the first column and last column
        for(int i=0;i<row;i++){
            // first column
            if (visited[i][0]==0 && arr[i][0]==1) {
                dfs(i,0, visited, arr, dx, dy);
            }
            //last column
            if (visited[i][col-1]==0 && arr[i][col-1]==1) {
                dfs(i, col-1, visited, arr, dx, dy);
            }
        }

        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (visited[i][j]==0 && arr[i][j]==1) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[][] arr = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int row = 4;
        int col = 4;


        int ans = noOfEnclaves(arr,row,col);
        System.out.println(ans);

    }
}