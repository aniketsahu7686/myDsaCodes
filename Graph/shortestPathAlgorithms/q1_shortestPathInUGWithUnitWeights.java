

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class q1_shortestPathInUGWithUnitWeights {

    public static int[] shortestPath(int[][] edges,int n,int m,int src){
        // first we will create a adjaceny list of size N to store the undirected graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // then a dist array of size N  are initialized with a large number to indicate that initially all the nodes are untraversed
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int)1e9; 
            // Inside the loop, each element of the array dist is being assigned the value (int)1e9.
            // 1e9 is scientific notation for 1×10power9 or 1000000000.
            // (int)1e9 casts this value to an integer, which is often used in competitive programming or algorithms to represent a 
            // very large number, typically used as an initial value for distances in shortest path algorithms (like Dijkstra's algorithm)
            // to indicate "infinity".
            // dist[i] = (int)1e9;
        }
        dist[src] = 0;


        // now continue with the normal BFS implementation
        Queue<Integer> q = new LinkedList<>(); 
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for(int it:adj.get(node)){
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        // and finally we will mark the unreachable nodes as -1;
        for(int i=0;i<n;i++){
            if (dist[i]==1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args){
        int n = 9, m = 10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        int[] ans = shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}


// Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’} + O(N + 2M) { for the BFS Algorithm} + O(N) 
//                  { for adding the final values of the shortest path in the resultant array} ~ O(N+2M). 
//                  Where N= number of vertices and M= number of edges.

// Space Complexity:  O( N) {for the stack storing the BFS} + O(N) {for the resultant array} + O(N) {for the dist array storing 
//                    updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .
//                    Where N= number of vertices and M= number of edges.