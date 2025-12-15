import java.util.*;

public class q6_bellmanFordAlgo {

    public static int[] bellmanFord(int vertices,int source,ArrayList<ArrayList<Integer>> edges){
        int[] ans = new int[vertices];

        for(int i=0;i<vertices;i++){
            ans[i] = (int)(1e9);
        }

        ans[source] = 0;

        // we have to relax all the edges N-1 times sequentially
        for(int i=0;i<vertices-1;i++){
            for(ArrayList<Integer> it:edges){
                int start = it.get(0);
                int destination = it.get(1);
                int weight = it.get(2);

                if (ans[start]!=1e9 && ans[start] + weight <ans[destination]) {
                    ans[destination]  = ans[start] + weight;
                }
            }
        }


        // Nth relaxation to check the negative cycle
        for(ArrayList<Integer> it:edges){
            int start = it.get(0);
                int destination = it.get(1);
                int weight = it.get(2);

                if (ans[start] + weight <ans[destination]) {
                    int[] temp = new int[1];
                    temp[0] = -1;
                    return temp;
                }
        }

        return ans;
    }
    public static void main(String[] args) {
        int V = 6;
        int S = 0;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(){
            {
                add(new ArrayList<Integer>(Arrays.asList(3,2,6)));
                add(new ArrayList<Integer>(Arrays.asList(5,3,1)));
                add(new ArrayList<Integer>(Arrays.asList(0,1,5)));
                add(new ArrayList<Integer>(Arrays.asList(1,5,-3)));
                add(new ArrayList<Integer>(Arrays.asList(1,2,-2)));
                add(new ArrayList<Integer>(Arrays.asList(3,4,-2)));
                add(new ArrayList<Integer>(Arrays.asList(2,4,3)));
            }
        };

        int[] ans = bellmanFord(V,S,edges);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}



// Time Complexity: O(V*E), where V = no. of vertices and E = no. of Edges.
// Space Complexity: O(V) for the distance array which stores the minimized distances.