package interview;

import java.util.ArrayList;

public class q15_rootToLeafNodes {

    public static boolean dfsToNodes(Node node, int x, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp) {
        if (node == null) {
            return false;
        }

        temp.add(node.data);

        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(temp));  // Add a copy of temp
        }

        dfsToNodes(node.left, x, ans, temp);
        dfsToNodes(node.right, x, ans, temp);

        temp.remove(temp.size() - 1);

        return false;
    }

    public static ArrayList<ArrayList<Integer>> rootToLeafNodes(Node root, int x) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        dfsToNodes(root, x, ans, temp);
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

        ArrayList<ArrayList<Integer>> arr = rootToLeafNodes(root, 7);

        for (ArrayList<Integer> it : arr) {
            printList(it);
        }
    }

    public static void printList(ArrayList<Integer> arr) {
        for (int it : arr) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
