import java.util.*;

class Pair{
    Node root;
    int value;
    Pair(Node root,int value){
        this.root = root;
        this.value = value;
    }
}
public class q9_iterativeAllInOneTraversal {

    public static List<List<Integer>> allInOneTraversal(Node root){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        // if the tree is empty return the empty traversal
        if (root==null) {
            return new ArrayList<>();
        }

        // stack to maintain nodes and their travesals state
        Stack<Pair> st = new Stack<>();

        // Start with the root node and state 1 (preorder)
        st.push(new Pair(root,1));

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // if the value is 1 , then it will go to preorder
            if (it.value==1) {
                preorder.add(it.root.data);
                it.value=2;
                st.push(it);

                // now we will push the left child
                if (it.root.left!=null) {
                    st.push(new Pair(it.root.left,1));
                }
            }
            else if (it.value==2) {
                inorder.add(it.root.data);
                it.value = 3;
                st.push(it);

                if (it.root.right!=null) {
                    st.push(new Pair(it.root.right, 1));
                }
            }
            else{
                postorder.add(it.root.data);
            }
        }

        list.add(preorder);
        list.add(inorder);
        list.add(postorder);

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

        List<List<Integer>> arr = allInOneTraversal(root);

        List<Integer> preorder,inorder,postorder;

        preorder = arr.get(0);
        inorder = arr.get(1);
        postorder = arr.get(2);

        System.out.print("Preorder : ");
        printList(preorder);
        System.out.print("inorder : ");
        printList(inorder);
        System.out.print("Postorder: ");
        printList(postorder);
    
    }
    public static void printList(List<Integer> arr){
        for(int it:arr){
            System.out.print(it + " ");
        }
        System.out.println();
    }
}
