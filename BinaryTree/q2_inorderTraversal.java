import java.util.ArrayList;
import java.util.List;

public class q2_inorderTraversal {

    public static void inorder(Node root,List<Integer> list){
        if (root==null) {
            return;
        }

        //traverse the left subtree
        inorder(root.left, list);

        // root
        list.add(root.data);

        //traverse the right subtree
        inorder(root.right, list);
    }
    public static List<Integer> inorderTraversal(Node root){
        // we have created a list to store the inorder traversal of the binary tree
        List<Integer> list = new ArrayList<>();

        inorder(root, list);

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

        List<Integer> arr = inorderTraversal(root);

        for(int it:arr){
            System.out.print(it + " ");
        }
    }
}


// Time Complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once.

// Space Complexity: O(N) where N is the number of nodes in the binary tree. This is because the recursive stack uses an auxiliary space
// which can potentially hold all nodes in the tree when dealing with a skewed tree (all nodes have only one child), consuming space
// proportional to the number of nodes.In the average case or for a balanced tree, the maximum number of nodes that could be in the
// stack at any given time would be roughly the height of the tree hence O(log2N).