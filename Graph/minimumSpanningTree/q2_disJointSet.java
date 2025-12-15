package minimumSpanningTree;
import java.util.ArrayList;
import java.util.*;

// here we are using the disjoint data structure using    (Union by rank)

public class q2_disJointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public q2_disJointSet(int n){
        // n is for no of nodes
        for(int i=0;i<=n;i++){
            rank.add(0);
            rank.add(i);
        }
    }
    public static void main(String[] args) {
        q2_disJointSet ss = new q2_disJointSet(7);


    }
}
