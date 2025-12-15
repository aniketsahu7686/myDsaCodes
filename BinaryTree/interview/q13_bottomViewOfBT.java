package interview;


import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    TreeNode node;
    int vertical;
    int level;
    Pair(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

class q13_bottomViewOfBT {
    public static List<Integer> topViewOfBT(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> qt = new LinkedList<>();

        qt.offer(new Pair(root, 0, 0));

        while (!qt.isEmpty()) {
            Pair pair = qt.poll();
            TreeNode tempnode = pair.node;
            int x = pair.vertical;
            int y = pair.level;

            map.put(x, tempnode.val);

            if (tempnode.left != null) {
                qt.offer(new Pair(tempnode.left, x - 1, y + 1));
            }

            if (tempnode.right != null) {
                qt.offer(new Pair(tempnode.right, x + 1, y + 1));
            }
        }

        List<Integer> ans = new ArrayList<>();

       for(int it:map.values()){
        ans.add(it); 
       }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> arr = topViewOfBT(root);

        for (int it : arr) {
            System.out.print(it + " ");
        }
    }
}

