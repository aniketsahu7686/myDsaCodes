import java.util.*;;

public class q10_recursiveAllInOne {
    static List<List<Integer>> list;
    public static void allInOneTraversal(Node root){
       if(root!=null) {
        list.get(0).add(root.data);
        allInOneTraversal(root.left);
        list.get(1).add(root.data);
        allInOneTraversal(root.right);
        list.get(2).add(root.data);
       }

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        allInOneTraversal(root);

        System.out.println("Preorder : " + list.get(0));
        
        System.out.println("inorder : " + list.get(1));
        
        System.out.println("Postorder: " + list.get(2));
    
    }
}
