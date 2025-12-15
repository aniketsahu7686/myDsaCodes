package interview;

import java.util.*;

class q16_widthOfBT  {
    public class Pair{
        TreeNode node;
        int value;
        Pair(TreeNode node,int value){
            this.node = node;
            this.value = value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        int ans = 0;

        Queue<Pair> qt = new LinkedList<>();
        qt.offer(new Pair(root,0));

        while(!qt.isEmpty()){
            int size = qt.size();
            // so these is the min index in that perspective level
            int minIndex =  qt.peek().value;
            int start=0,end=0;

            for(int i=0;i<size;i++){
                 int currentIndex = qt.peek().value - minIndex;
                 TreeNode node = qt.peek().node;
                 qt.poll();

                 if(i==0){
                    start = currentIndex;
                 }

                 if(i== size-1){
                    end = currentIndex;
                 }


                 if(node.left!=null){
                    qt.offer(new Pair(node.left, 2 * currentIndex + 1));
                 }

                 if(node.right!=null){
                    qt.offer(new Pair(node.right,2 * currentIndex + 2));
                 }
            }

            ans = Math.max(ans,(end-start)+1);
        }

        return ans;
    }   
}

// Time Complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued 
//                  exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations
//                  which contributes to the overall linear time complexity.

// Space Complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of 
//                   the last level of the binary tree, the last level could at most hold N/2 nodes hence the space complexity of the queue
//                   is proportional to O(N).