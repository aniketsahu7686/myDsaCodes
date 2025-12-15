import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q5_levelOrderTraversal {
    public static List<List<Integer>> levelorderTraversal(Node root){
        // here we have created a list to store the nodes
        List<List<Integer>> list = new ArrayList<>();
        if (root==null) {
            return null;
        }
        Queue<Node> qt = new LinkedList<>();

        qt.add(root);


        while (!qt.isEmpty()) {
            // we are taking the size , so that  we can print the level at a time
            int size = qt.size();

            // we are intialzing a new level list everytime for everytime , we are traversing every level
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++){
                Node  newRoot = qt.poll();

                level.add(newRoot.data);


                if (newRoot.left!=null) {
                    qt.add(newRoot.left);
                }
                if (newRoot.right!=null) {
                    qt.add(newRoot.right);
                }                
            }

            list.add(level);
        }
        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        List<List<Integer>> arr = levelorderTraversal(root);

        for(List<Integer> level:arr){
            printList(level);
        }
    }
    public static void printList(List<Integer> level){
        for(int it:level){
            System.out.print(it + " ");
        }
    }
}
