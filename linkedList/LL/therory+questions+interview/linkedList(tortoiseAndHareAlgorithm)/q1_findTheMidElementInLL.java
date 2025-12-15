class ListNode  {
    int data;
    ListNode next;
    // create three constructors
    // 1
    ListNode(){}
    //2
    ListNode(int data){
        this.data = data;
    }
    //3
    ListNode(ListNode next,int data){
        this.data = data;
        this.next = next;
    }
}
public class q1_findTheMidElementInLL {
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
    public static ListNode findMidElementOfLL(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast!=null &&  fast.next!=null) {
            // increase the slow to next
            slow = slow.next;
            // increase the fast to next of next
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String args[]) {
        ListNode head = null;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        System.out.println(findMidElementOfLL(head));
        
    }
}

// TC : O(N) 
// SC : O(1)
