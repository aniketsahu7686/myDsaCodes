/// Here we have simply implemented the representation of Binary Tree
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class q1_btRepresentation {
    public static void main(String[] args) {

        // here is the sample of the binary tree
        Node n = new Node(2);
        n.left = new Node(5);
        n.right = new Node(6);
        n.left.left = new Node(8);
    }
}