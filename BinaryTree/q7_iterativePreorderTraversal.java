import java.util.*;

public class q7_iterativePreorderTraversal {
    public static List<Integer> iterativePreoder(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st.add(root);

        while (!st.isEmpty()) {
            root = st.pop();
            list.add(root.data);
            if (root.right!=null) {
                st.add(root.right);
            }
            if (root.left!=null) {
                st.add(root.left);
            }
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

        List<Integer> arr = iterativePreoder(root);

        for(int it:arr){
            System.out.print(it + " ");
        }
    }
}


// TC : O(N);
// SC : O(N);
