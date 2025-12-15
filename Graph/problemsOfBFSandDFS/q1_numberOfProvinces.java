import java.util.ArrayList;
import java.util.Scanner;

public class q1_numberOfProvinces {

    public static void dfs(int node ,ArrayList<ArrayList<Integer>> adjList,int[] visited){
        visited[node] = 1;
        for(Integer it:adjList.get(node)){
            if (visited[it]==0) {
                dfs(it, adjList, visited);
            }
        }
    }
    public static int numOfProvinces(ArrayList<ArrayList<Integer>> adj ,int n){
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            adjLs.add(new ArrayList<Integer>()); 
        }
            // now we will change the adjacency matrix to the list so that it will help us to relate the nodes
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // so here self nodes are not considered
                if (adj.get(i).get(j) == 1 && i!=j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int[] visited = new int[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if (visited[i]==0) {
                cnt++;
                dfs(i,adjLs,visited);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

     adj.add(new ArrayList<Integer>());
     adj.get(0).add(0,1);
     adj.get(0).add(1,0);
     adj.get(0).add(2,0);

     adj.add(new ArrayList<Integer>());
     adj.get(1).add(0,0);
     adj.get(1).add(1,1);
     adj.get(1).add(2,0);

     adj.add(new ArrayList<Integer>());
     adj.get(2).add(0,0);
     adj.get(2).add(1,0);
     adj.get(2).add(2,1);

     int ans = numOfProvinces(adj, 3);
     System.out.println(ans);
    }
}


// Time Complexity: O(N) + O(V+2E), Where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph, and we know DFS takes a time of O(V+2E). 

// Space Complexity: O(N) + O(N),Space for recursion stack space and visited array.