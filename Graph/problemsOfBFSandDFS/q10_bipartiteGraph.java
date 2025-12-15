import java.util.ArrayList;

public class q10_bipartiteGraph {
    private static boolean dfs(int node,int color,int[] visited,ArrayList<ArrayList<Integer>> adj){
        // assign the nodes with the respective colors
        visited[node] = color;


        // traverse adjacent nodes
        for(Integer it:adj.get(node)){
            // if uncoloured 
            if (visited[node]==-1) {
                if (dfs(node, 1-color, visited, adj)==false) {
                    return false;
                }
            }
            // if previously coloured and have the same colour 
            else  if (visited[it]==color) {
                return false;
            }
        }

        return true;

    }
    public static boolean bipartiteGraph(int v,ArrayList<ArrayList<Integer>> adj){
        // here we will make an visited array which will store the color ,we will assign to the nodes
        int[ ] visited = new int[v];
        // but initially we will mark all the positions of array as 1 , beacuse we are using two colors here color1  - 0 , color2 - 1
        // as  bipartite graph only have two colors
        for(int i=0;i<v;i++){
            visited[i]=-1;
        }

        // for connected components
        for(int i=1;i<=v;i++){
            // when  then vistied array position is -1 then call dfs
            if (visited[i]==-1) {
                if (dfs(i,0,visited,adj)==false ) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args){
        // here v stands for the vertices
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);        
        adj.get(2).add(1);        
        adj.get(2).add(3);        
        adj.get(2).add(6);        
        adj.get(3).add(2);        
        adj.get(3).add(4);        
        adj.get(4).add(3);        
        adj.get(4).add(7);        
        adj.get(4).add(5);        
        adj.get(5).add(4);        
        adj.get(5).add(6);        
        adj.get(6).add(2);        
        adj.get(6).add(5);        
        adj.get(7).add(4);        
        adj.get(7).add(8);        
        adj.get(8).add(7);        

        boolean ans = bipartiteGraph(v,adj);
        System.out.println(ans);
    }
}


// Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.

// Space Complexity: O(3V) ~ O(V), Space for DFS stack space, colour array and an adjacency list.