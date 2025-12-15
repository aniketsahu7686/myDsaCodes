import java.util.*;


class tuple{
    int first, second, third;
    tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

}

public class q5_shortestDistanceInAMaze {
    public static int findShortestDistance(int[][] grid,int[] source,int[] destination){
        // Edge case : if the source is only the destination
        if (source[0]==destination[0] && source[1]==destination[1]) {
            return 0;
        }

        // Create a queue for storing cells with their distances from source in the form {dist,{cell coordinates pair}}.4
        Queue<tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;


        // Create a distance matrix with initially all the cells marked as unvisited and the source cell as 0. 
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)(1e9);
            }
        }

        dist[source[0]][source[1]] = 0;
        q.add(new tuple(0, source[0], source[1]));


        // row and columns array are for going to four directions of a node
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};


        // Iterate through the maze by popping the elements out of the queue and pushing whenever a shorter distance to a cell is found.
        while (!q.isEmpty()) {
            tuple it = q.poll();
            int dis = it.first;
            int row = it.second;
            int col = it.third;

            // Through this loop, we check the 4 direction adjacent nodes for a shorter path to destination.
            for(int i=0;i<4;i++){
                int newrow = row + dx[i];
                int newcol = col + dy[i];


                // Checking the validity of the cell and updating if dist is shorter.
                if (newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==1 && dis + 1 < dist[newrow][newcol] ) {
                    dist[newrow][newcol] = 1 + dis;

                    if (newrow == destination[0] && newcol == destination[1] ) {
                        return dis + 1; 
                    }
                    q.add(new tuple(dis + 1, newrow, newcol));
                }
            }
        }
        // If no path is found from source to destination.
        return -1;
    }
    public static void main(String[] args){
        int[][] grid = {{1, 1, 1, 1},{1, 1, 0, 1}, {1, 1, 1, 1},{1, 1, 0, 0},{1, 0, 0, 1}};
        int[] source = {0,1};
        int[] destination = {2,2};

        int ans = findShortestDistance(grid,source,destination);
        System.out.println(ans);
    }
}


// Time Complexity: O( 4*N*M ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for the shortest path length}, Where N = No. of rows
//                  of the binary maze and M = No. of columns of the binary maze.

// Space Complexity: O( N*M ), Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.