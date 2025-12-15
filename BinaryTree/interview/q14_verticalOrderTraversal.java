package interview;

import java.util.*;;
//  Definition for a binary tree node.
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
 
 
 class q14_verticalOrderTraversalOfBt  {
    public class Pair{
        TreeNode node;
        int vertical;
        int level;
        Pair(TreeNode node,int vertical,int level){
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
       Queue<Pair> qt = new LinkedList<>();

       qt.offer(new Pair(root,0,0));

       while(!qt.isEmpty()){
        Pair pair = qt.poll();
        TreeNode tempnode = pair.node;
        int x = pair.vertical;
        int y = pair.level;

        if(!map.containsKey(x)){
            map.put(x,new TreeMap<>());
        }

        if(!map.get(x).containsKey(y)){
            map.get(x).put(y,new PriorityQueue<Integer>());
        }

        map.get(x).get(y).offer(tempnode.val);

        if(tempnode.left!=null){
            qt.offer(new Pair(tempnode.left,x-1,y+1));
        }

        if(tempnode.right!=null){
            qt.offer(new Pair(tempnode.right,x+1,y+1));
        }
       }

       List<List<Integer>> ans = new ArrayList<>();

       for(TreeMap<Integer,PriorityQueue<Integer>> it:map.values()){
        ans.add(new ArrayList<>());
        for(PriorityQueue<Integer> n: it.values()){
            while(!n.isEmpty()){
                ans.get(ans.size()-1).add(n.poll());
            }
        }
       } 
       return ans;
    }
}