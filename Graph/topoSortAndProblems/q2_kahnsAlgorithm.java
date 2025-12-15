package topoSortAndProblems;
import java.util.*;


public class q2_kahnsAlgorithm {

    public static int[] topoSort(int v,ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if (indegree[i]==0) {
                q.add(i);
            }
        }


        int[] topo = new int[v];
        int i=0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;

            // node will be in our toposort , so we should remove it from the indegree
            for(int it:adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0) {
                    q.add(it);
                }
            }
        }

        return topo; 
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);


        int[] ans = topoSort(v,adj);
        for(int node:ans){
            System.out.print(node + " ");
        }
        System.out.println();
    }
}


// Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

// Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in
//                   BFS(where N = no.of nodes).

