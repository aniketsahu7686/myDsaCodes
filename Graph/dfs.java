import java.util.ArrayList;

public class dfs {
     public static void dfsSol(int node,boolean visited[], ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list){
        // as this is the recursion method we have to do all the operations here

        // marking current node as visited
        visited[node] = true;
        list.add(node);

        // getting the neighbour nodes
        for(Integer it:adj.get(node)){
            if (visited[it] == false) {
                dfsSol(it, visited, adj, list);
            }
        }
     }

     public static ArrayList<Integer> dfsOfGraph(int n,ArrayList<ArrayList<Integer>> adj){
        // boolean array to keep track of the visited nodes
        boolean vis[] = new boolean[n+1];
        // we considered this as the 1 based index
        vis[1] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfsSol(1, vis, adj, ls);
        return ls;
     }

     public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=8;i++){
            adj.add(new ArrayList<>());
        }
         adj.get(1).add(2);
        adj.get(1).add(6);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(2);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(7);
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(8);
        adj.get(7).add(6);
        adj.get(7).add(5);
        adj.get(8).add(6);

        ArrayList<Integer> ans = dfsOfGraph(8,adj);
        int n = ans.size();
        for(int i=0;i<n;i++){
            System.out.print(ans.get(i) + " ");
        } 
     }
}


// Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are calling 
// the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

// Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.