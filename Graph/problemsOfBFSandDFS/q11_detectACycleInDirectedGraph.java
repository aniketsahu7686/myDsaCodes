import java.util.ArrayList;

public class q11_detectACycleInDirectedGraph {
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,int[] pathVisited){
        visited[node] = 1;
        pathVisited[node] = 1;

        // traverse for the adjacent nodes
        for(int it:adj.get(node)){
            // when the node is not visited
            if (visited[it]==0) {
                if (dfs(it, adj, visited, pathVisited)==true) {
                    return true;
                }
            }

            // if the node has been previously visited and we are going to this node again
            else if (pathVisited[it]==1) {
                return true;
            }
        }

        // when we are coming back then again mark the pathVisited as 0
        pathVisited[node] = 0;
        return false;
    }

    // so this is the function to detect whether a cycle is contains in the directed graph 
    public static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        int pathVisited[] = new int[V];


        for(int i=0;i<V;i++){
            if (vis[i]==0) {
                if (dfs(i,adj,vis,pathVisited)==true) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int v = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        boolean ans = isCycle(v, adj);
        System.out.println(ans);
    }
}



// Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges. There can be at most V components.
//                  So, another O(V) time complexity.

// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N) for recursive stack space.
