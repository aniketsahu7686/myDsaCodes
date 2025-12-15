import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class bfs {
    public static ArrayList<Integer> bgfOfGraph(int n,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer>  bfs = new ArrayList<>();

        // we are creating the visited array ,so that we can know which node is visited or not
        // so here we are considering 1 based index ,thats the reason it took the size as n+1 otherwise when it is 0 based index ,then we can take the visted size as n only
        boolean visited[] = new boolean[n+1];

        // also create an queue
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true; 

        // for 0 based index we can intitialize it as
        // q.add(0);
        // visited[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            // get all the adjacent vertices of the dequeued vertex , now if a adjacent has not been visited,then mark it 
            // visited and enqueue it 
            for(Integer it:adj.get(node)){
                if (visited[it] == false) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args){
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


        ArrayList<Integer> ans = bgfOfGraph(8, adj);
        int n =ans.size();
        for(int i=0;i<n;i++){
            System.out.print(ans.get(i) + " ");
        }

    }
}


// Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
// Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list

