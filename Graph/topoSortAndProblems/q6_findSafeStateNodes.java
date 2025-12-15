package topoSortAndProblems;

import java.util.*;

public class q6_findSafeStateNodes {

    public static List<Integer> eventualSafeNodes(int v,List<List<Integer>> adj){
        List<List<Integer>> adjRev = new ArrayList<>();

        for(int i=0;i<v;i++){
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            // here there is i--> it
            // we will reverese it to it-->i
            for(int it:adj.get(i)){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> qt = new LinkedList<>();
        List<Integer> safeNodes  = new ArrayList<>();
        for(int i=0;i<v;i++){
            if (indegree[i]==0) {
                qt.add(i);
            }
        }

        while(!qt.isEmpty()){
            int node = qt.poll();
            safeNodes.add(node);
            for(int it:adjRev.get(node)){
                indegree[it]--;
                if (indegree[it]==0) {
                    qt.add(it);
                }
            }
        }


        Collections.sort(safeNodes);
        return safeNodes;
    }
    public static void main(String[] args){
        int v = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        List<Integer> ans = eventualSafeNodes(v,adj);

        for(int node:ans){
            System.out.print(node + " ");
        }
        System.out.println();
    }
}



// Time Complexity: O(V+E)+O(N*logN), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.
//                  Extra O(N*logN) for sorting the safeNodes array, where N is the number of safe nodes.

// Space Complexity: O(N) + O(N) + O(N) ~ O(3N), O(N) for the indegree array, O(N) for the queue data structure used
//                   in BFS(where N = no.of nodes), and extra O(N) for the adjacency list to store the graph in a reversed order.