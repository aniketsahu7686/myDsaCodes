package topoSortAndProblems;

import java.util.ArrayList;
import java.util.Stack;

public class q1_topologicalSort {

    public static void dfs(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int it:adj.get(node)){
            if (vis[it]==0) {
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);
    }

    public static int[] topoSort(int v,ArrayList<ArrayList<Integer>> adj){

        // first create an visited array to check if the node is visited or not
        int vis[] = new int[v];
        // then create a stack to store the elements so that it can produce the correct order of the topological sort
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<v;i++){
            if (vis[i]==0) {
                dfs(i,vis,st,adj);
            }
        }
        // now remove the elements one by one from the stack and put it in an array so that we can print the array
        int[] ans = new int[v];
        int i = 0;
        while (!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }

    public static void main(String[] args){
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);


        int[] ans= topoSort(V,adj);
        for(int node:ans){
            System.out.print(node + " ");
        }
        System.out.println();
    }
}



// Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. 
//                  So, another O(V) time complexity.

// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack carried during DFS calls and O(N) for recursive 
//                   stack space, where N = no. of nodes.

