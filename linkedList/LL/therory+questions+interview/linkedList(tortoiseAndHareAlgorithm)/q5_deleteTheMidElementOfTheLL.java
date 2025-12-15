public class q5_deleteTheMidElementOfTheLL {
    static ListNode insertNode(ListNode head,int val) {
        ListNode newNode = new ListNode(val);
        
        if(head == null) {
            head = newNode;
            return head;
        }
        
        ListNode temp = head;
        while(temp.next != null) temp = temp.next;
        
        temp.next = newNode;
        return head;
    }
    public static ListNode deleteTheMid(ListNode head){
        if (head==null || head.next==null) {
            return null;
        }
        ListNode slow = head, fast = head;
        fast  = fast.next.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // TC:O(N/2) ,as we are going till the half of the linkedlist
    // SC: O(1) , no extra spaces are used 
    
    public static void main(String args[]) {
        ListNode head = null;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        head=insertNode(head,10);
        head=insertNode(head,6);
        head=insertNode(head,2);
        head=insertNode(head,1);
        head=insertNode(head,8);
        head=insertNode(head,7);
        
        // ListNode nodeRecieve = findStartingPointBf(head);
        // int length = findLengthOfLoopBf(head);
        deleteTheMid(head);
        
        
    }
}
