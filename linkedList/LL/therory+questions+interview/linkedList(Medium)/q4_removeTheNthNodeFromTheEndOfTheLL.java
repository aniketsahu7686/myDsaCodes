public class q4_removeTheNthNodeFromTheEndOfTheLL {
     // function to remove the nth node from the end of the ll
    public static ListNode removeNthNodeBf(ListNode head,int n){
        // intialize a temp
        ListNode temp = head;
        int totalNodes = 0;
        // count the total nodes 
        while (temp!=null) {
            temp = temp.next;
            totalNodes++;
        }
        // if the totalNodes is equal the n then assign the newhead to head of next 
        if (totalNodes==n) {
            ListNode newHead = head.next;
            return newHead;
        }
        // the value which we need to find , so that we can delete the nth node
        int count = totalNodes - n;
        
        ListNode anotherTemp = head;

        // find the nth node
        while (anotherTemp!=null) {
            count--;
            if (count==0) {
                ListNode delteNode = temp.next;
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // TC : O(N) + O(total Nodes - n) = O(2N), first O(N) as we traverse the whole ll to know the total nodes of the ll and the 
    //      next one O(total Nodes - n) as we are traversing upto that element to  delete the node
    // SC : O(1) , no extra space is used 

    // function to remove the nth node from the end of the ll
    public static ListNode removeNthNodeOp(ListNode head,int n){
        // initialize a temporary 
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        // traverse the LL until the fast pointer reaches the nth node 
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        // then increase the pointer both one at a time ,  and stop when the fast pointer reaches null 
        while (fast.next!=null) {
            slow  = slow.next;
            fast = fast.next;
        }
        // assign the next of the slow to the next of next 
        slow.next = slow.next.next;

        return start.next;
    }    


    // TC : O(n) , as we are traversing the ll only one time
    // SC : O(1) , no extra spaces are used

}
