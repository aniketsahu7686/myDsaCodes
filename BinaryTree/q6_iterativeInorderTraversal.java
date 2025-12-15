import java.util.*;

public class q6_iterativeInorderTraversal {
    public static List<Integer> iterativeInorder(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        if (root==null) {
            return list;
        }

        while (true) {
            if (root!=null) {
                st.push(root);
                root = root.left;
            }else{
                if (st.isEmpty()) {
                    break;
                }
                root = st.pop();
                list.add(root.data);
                root = root.right;
            }
        }

        return list;
    }
     
}
