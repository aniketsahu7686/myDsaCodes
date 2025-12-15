package minimumSpanningTree;
import java.util.*;


class Pair{
    int distance;
    int node;

    Pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}
public class q1_primsAlgo {
    public static int primsAlgo(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj){
        // for getting the sum of the minimum spanning tree
        int sum = 0;

        // for getting the pairs of the minimum spanning tree (do it afterwards)
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();


        int[] vis = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance-y.distance);

        pq.add(new Pair(0, 0));  // {wt,node}

        while (pq.size()!=0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node]==1) {
                continue;
            }

            // add distance to sum 
            sum+=dis;
            vis[node] = 1;


            // now stand in the node and see the adj node and those node which are not visited add it to the pq
            for(int i=0;i<adj.get(node).size();i++){
                int adjNode = adj.get(node).get(i).get(0);
                int adjWght = adj.get(node).get(i).get(1);

                if (vis[adjNode]==0) {
                    pq.add(new Pair(adjWght, adjNode));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        // so here remember  ArrayList<ArrayList<ArrayList<Integer>>> this means till now only one ArrayList and inside that we can 
        //  add the rest that is ArrayList<ArrayList<Integer>> .

        
        int V = 5;
        // this is for the representation and making of the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        int[][] arr = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        // now we will start making of the graph

        for(int i=0;i<arr.length;i++){

            int u = arr[i][0];
            int v = arr[i][1];
            int wght = arr[i][2];


            ArrayList<Integer> temp1 = new ArrayList<Integer>();
            ArrayList<Integer> temp2 = new ArrayList<Integer>();


            temp1.add(v);
            temp1.add(wght);

            temp2.add(u);
            temp2.add(wght);

            adj.get(u).add(temp1);
            adj.get(v).add(temp2);
        }

        int sum = primsAlgo(V,adj);

        System.out.println(sum);

    }
}


// Time Complexity: O(E*logE) + O(E*logE)~ O(E*logE), where E = no. of given edges.
// The maximum size of the priority queue can be E so after at most E iterations the priority queue will be empty and the loop will end. 
// Inside the loop, there is a pop operation that will take logE time. This will result in the first O(E*logE) time complexity. Now, 
// inside that loop, for every node, we need to traverse all its adjacent nodes where the number of nodes can be at most E. If we find
// any node unvisited, we will perform a push operation and for that, we need a logE time complexity. So this will result in the second
// O(E*logE). 

// Space Complexity: O(E) + O(V), where E = no. of edges and V = no. of vertices. O(E) occurs due to the size of the priority queue and
//  O(V) due to the visited array. If we wish to get the mst, we need an extra O(V-1) space to store the edges of the most.

