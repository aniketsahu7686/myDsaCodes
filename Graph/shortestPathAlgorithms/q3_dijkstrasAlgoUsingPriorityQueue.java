
import java.util.ArrayList;
import java.util.PriorityQueue;


class Pair{
    int node;
    int distance;
    // here we will just change the place of node and distance to know the algorithm better
    public Pair(int distance,int node){
        this.distance = distance;
        this.node = node; 
    }
}

public class q3_dijkstrasAlgoUsingPriorityQueue {
    // so this is the function to find the shortest distance from Source node S to all the nodes
    public static int[] dijkstrasAlgo(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S){

        // Create a priority queue for storing the nodes as a pair {dist, node} where dist is the distance from source to the node. 
        // new PriorityQueue<Pair>(...): This creates a new instance of a PriorityQueue that will store Pair objects. 
        // (x, y) -> x.distance - y.distance: This is a lambda expression that defines a comparator to order the elements in the 
        // priority queue. 
           PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        //    Explanation of the Lambda Expression (x, y) -> x.distance - y.distance:
        // Comparator: The lambda expression (x, y) -> x.distance - y.distance is a comparator used to determine the order of the 
        // Pair objects in the priority queue.
        // Parameters x and y: These are the two Pair objects being compared.
        // x.distance - y.distance: This calculates the difference between the distance field of x and y. This expression:
        // Returns a negative value if x.distance is less than y.distance (indicating x should come before y in the queue).
        // Returns zero if x.distance is equal to y.distance.
        // Returns a positive value if x.distance is greater than y.distance (indicating x should come after y in the queue).


           int[] dist = new int[V];
           // Initialising distTo list with a large number to indicate the nodes are unvisited initially, This list contains
           // distance from source to the nodes.
           for(int i=0;i<V;i++){
            dist[i] = (int)(1e9);
           }

           // now first we will initialized with dist = 0
           dist[S] = 0;
           pq.add(new Pair(0, S));


           // Now, pop the minimum distance node first from the min-heap and traverse for all its adjacent nodes.
           while (pq.size()!=0){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // Check for all adjacent nodes of the popped out element whether the prev dist is larger than current or not.
            for(int i=0;i<adj.get(node).size();i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                 // If current distance is smaller, push it into the queue.
                 if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                 }
            }
        }
        // Return the list containing shortest distances from source to all the nodes.
        return dist;
    }
    public static void main(String[] args){
        int V = 3 , E = 3 , S = 2;

        // ArrayList<Integer> node1 = new ArrayList<Integer>();
        // node1.add(1);
        // node1.add(1);

        // instead of these we can assign the values directly

        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};


        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };

        int[] ans = dijkstrasAlgo(V, adj,S);
        for(int i=0;i<V;i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();

    }
}




// Time Complexity: O( E log(V) ), Where E = Number of edges and V = Number of Nodes.

// Space Complexity: O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.