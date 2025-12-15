 

import java.util.*;


public class q2_shortedPathInDirectedAcyclicGraph {

static class Pair{
    int first,second;
    Pair(int first,int second){
        this.first  = first;
        this.second = second;

    }
}

public static int[] shortestPath(int n,int m,int[][] edges){
    //  here we are creating the template for storing the adj elements of each node
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for(int i=0;i<n;i++){
        ArrayList<Pair> temp = new ArrayList<Pair>();
        adj.add(temp);
    }

    // then we will store the adjacent elements in the adj node
    for(int i=0;i<m;i++){
        int u = edges[i][0];
        int v = edges[i][1];
        int wght = edges[i][2];
        adj.get(u).add(new Pair(v, wght));
    }
    // now we will perform the toposort and store the result in the stack
    int[] vis = new int[n];
    Stack<Integer> st = new Stack<>();
    for(int i=0;i<n;i++){
        if (vis[i]==0) {
            topoSort(i,vis,adj,st);
        }
    }

     //Further, we declare a vector ‘dist’ in which we update the value of the nodes ,distance from the source vertex after
     // relaxation of a particular node.
     int[] dist = new int[n];
     for(int i=0;i<n;i++){
        dist[i] = (int)1e9;
     }

     dist[0] = 0;
     while (!st.isEmpty()) {
        int node = st.peek();
        st.pop();

        for(int i=0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            int wght = adj.get(node).get(i).second;

            if (dist[node] + wght < dist[v]) {
                dist[v] = dist[node] + wght;
            }
        }
     }

     for(int i=0;i<n;i++){
        if (dist[i] == 1e9) {
            dist[i] = -1;
        }
     }
     return dist;
}
// function to implement toposort
public static void topoSort(int node,int[] visited,ArrayList<ArrayList<Pair>> adj,Stack<Integer> stack){
    visited[node] = 1;
    for(int i=0;i<adj.get(node).size();i++){
        int v = adj.get(node).get(i).first;
        if (visited[v] == 0) {
            topoSort(v, visited, adj, stack);
        }
    }
    stack.add(node);
}
public static void main(String[] argss){
    int n = 6, m = 7;
    int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
    int[] res = shortestPath(n,m,edge);
    for(int i=0;i<n;i++){
        System.out.print(res[i] + " ");
    }
    System.out.println();
}
}


// Time Complexity: O(N+M) {for the topological sort} + O(N+M) {for relaxation of vertices, each node and its adjacent
//                  nodes get traversed} ~ O(N+M).
// Where N= number of vertices and M= number of edges.

// Space Complexity:  O( N) {for the stack storing the topological sort} + O(N) {for storing the shortest distance for each node} + O(N)
//                   {for the visited array} + O( N+2M) {for the adjacency list} ~ O(N+M) .
// Where N= number of vertices and M= number of edges. 