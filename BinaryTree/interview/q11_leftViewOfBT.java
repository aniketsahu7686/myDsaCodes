package interview;

import java.util.*;

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

public class q11_leftViewOfBT {
    public static void leftView(Node root,int level,ArrayList<Integer> list){
        if (root==null) {
            return;
        }

        // condition if when the size of the arraylist is equal to the size of the level , then add the node in the list
        if (list.size()==level) {
            list.add(root.data);
        }

        leftView(root.left, level+1, list);
        leftView(root.right, level+1, list);
    }

    public static ArrayList<Integer> leftViewOftheBt(Node root){
        ArrayList<Integer> list = new ArrayList<>();

        leftView(root,0,list);

        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        ArrayList<Integer> ans = leftViewOftheBt(root);

        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}


// Time Complexity: O(log2N) where N is the number of nodes in the Binary Tree. This complexity arises as we travel along the height
//  of the Binary Tree. For a balanced binary tree, the height is log2N but in the worst case when the tree is skewed, the complexity
//   becomes O(N).

// Space Complexity : O(log2N) where N is the number of nodes in the Binary Tree. This complexity arises because we store the leftmost
//  and rightmost nodes in an additional vector. The size of this result vector is proportional to the height of the Binary Tree which
//   will be log2N when the tree is balanced and O(N) in the worst case of a skewed tree.

// O(H): Recursive Stack Space is used to calculate the height of the tree at each node which is proportional to the height of the tree.
// The recursive nature of the getHeight function, which incurs space on the call stack for each recursive call until it reaches the 
// leaf nodes or the height of the tree.