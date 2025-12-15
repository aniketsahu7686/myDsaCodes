package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q15_rootToLeafNodeX {
    public static boolean dfsToNodeX(Node node,int x,ArrayList<Integer> ans){
        if (node==null) {
            return false;
        }

        ans.add(node.data); 
        if (node.data==x) {
            return true;
        }

        if (dfsToNodeX(node.left, x, ans) || dfsToNodeX(node.right, x, ans) ) {
            return true;
        }

        ans.remove(ans.size()-1);
        return false;
    }
    public static ArrayList<Integer> rootToLeafNodeX(Node root,int x){
        ArrayList<Integer> ans = new ArrayList<>();
        if (root==null) {
            return ans;
        }

        dfsToNodeX(root,x,ans);
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> arr = rootToLeafNodeX(root,7);

        for(int it:arr){
            System.out.print(it + " ");
        }
    }
}
