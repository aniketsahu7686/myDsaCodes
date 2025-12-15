package OthersAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

class q1_kosaRajusAlgo {
    public static int kosaRajuAlgo(int n,ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        int i = 0;
        return i;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,0},{0,2},{0,3},{2,4},{3,4}};


        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int ans = kosaRajuAlgo(n,adj);
        System.out.println(ans);
    }
}