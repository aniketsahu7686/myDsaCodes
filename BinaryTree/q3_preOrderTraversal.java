import java.util.ArrayList;
import java.util.List;

public class q3_preOrderTraversal {
    public static void preorder(Node root,List<Integer> list){
        if (root==null) {
            return;
        }

        // root
        list.add(root.data);

        //traverse the left subtree
        preorder(root.left, list);

        //traverse the right subtree
        preorder(root.right, list);
    }
    public static List<Integer> preorderTraversal(Node root){
        // we have created a list to store the inorder traversal of the binary tree
        List<Integer> list = new ArrayList<>();

        preorder(root, list);

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

        List<Integer> arr = preorderTraversal(root);

        for(int it:arr){
            System.out.print(it + " ");
        }
    }
}


// Time Complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once.

// Space Complexity: O(N) where N is the number of nodes in the binary tree as an additional space for array is allocated to store the
//                   values of all ‘N’ nodes of the binary tree.