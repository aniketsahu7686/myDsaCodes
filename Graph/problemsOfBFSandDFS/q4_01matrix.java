import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int first;
    int second;
    int third;

    Node(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class q4_01matrix {
    public static int[][] zero1matrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] visited  = new int[row][col];
        int[][] distance = new int[row][col];

        Queue<Node> qt = new LinkedList<Node>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                // start BFS if cell contains 1
                if (matrix[i][j]==0) {
                    qt.add(new Node(i, j, 0));
                    visited[i][j]=1;
                }else{
                    visited[i][j]=0;
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};


        while (!qt.isEmpty()) {
            int n = qt.peek().first;
            int m = qt.peek().second;
            int steps = qt.peek().third;
            qt.remove();
            distance[n][m] = steps;

            // no for the all the 4 neighbours
            for(int i=0;i<4;i++){
                int nrow = dx[i] + n;
                int mcol = dy[i] + m;

                if(nrow>=0 && mcol>=0 && mcol<m && nrow<n && visited[nrow][mcol]== 0 ) {
                    visited[nrow][mcol] = 1;
                    qt.add(new Node(nrow,mcol,steps+1));
                }
            }
        }
        return distance; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ans = zero1matrix(arr);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
