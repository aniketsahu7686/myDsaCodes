

import java.util.LinkedList;
import java.util.Queue;

public class q2_rottenOranges {
    public static int orangeRotting(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        // we will initialize a queue to insert all the rotten oranges
        Queue<int[]> qt = new LinkedList<>();
        // we have to count the total no of oranges
        int totalOranges = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if (matrix[i][j]==2) {
                    qt.offer(new int[]{i,j});
                }
                if (matrix[i][j]!=0) {
                    totalOranges++;  
                }
            }
        }


        if (totalOranges == 0) {
            return 0;
        }
        int totalTime = 0;
        // here we have taken cnt = totalRottenOrange
        int totalRottenOrange = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};


        // now bfs starting from initially rotten oranges
        while (!qt.isEmpty()) {
            int size = qt.size();
            totalRottenOrange += size;

            for(int i=0;i<size;i++){
                int[] count = qt.poll();
                for(int j=0;j<4;j++){
                    int x = count[0] + dx[j];
                    int y = count[1] + dy[j];

                    if (x<0 || y<0 || x>=rows || y>=cols || matrix[x][y]==0 ||matrix[x][y]==2) {
                        continue;
                    }
                    
                    matrix[x][y] = 2;
                    qt.offer(new int[]{x,y});
                    
                }
            }

            if (qt.size()!=0) {
                totalTime++;
            }
        }

        return totalOranges == totalRottenOrange ? totalTime:-1;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = orangeRotting(matrix);
        System.out.println(ans);
    }
}


// Time Complexity: O ( n x n ) x 4    
// Reason: Worst-case - We will be making each fresh orange rotten in the grid and for each rotten orange will check in 4 directions

// Space Complexity: O ( n x n )
// Reason: worst-case -  If all oranges are Rotten, we will end up pushing all rotten oranges into the Queue data structure