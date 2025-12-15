import java.util.HashSet;
import java.util.List;

public class q3_findTheStartingElementOfTheCycleInLL {
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
    
    //utility function to create cycle
    static void createCycle(ListNode head,int a,int b) {
        int cnta = 0,cntb = 0;
        ListNode p1 = head; 
        ListNode p2 = head;
        while(cnta != a || cntb != b) {
            if(cnta != a) 
            {p1 = p1.next; ++cnta;}
            if(cntb != b) 
            {p2 = p2.next; ++cntb;}
        }
        p2.next = p1;
    }
    // Brute force Approach , using Hashing

    public static ListNode findStartingPointBf(ListNode head){
        // first create a Hashset
        HashSet<ListNode> st = new HashSet<>();
        while (head!=null) {
            if (st.contains(head)) {
                return head;
            }
            st.add(head);
            head = head .next;
        }
        return null;
    }

    // TC : O(N) , as we are travesing the whole ll one time
    // SC : O(N) , we store all nodes in a hash table



    // Optimal approach
    public static ListNode findStartingPointOp(ListNode head){
        if (head==null || head.next==null) {
            return null;
        }
        ListNode slow = head, fast = head , entry = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                while (slow!=entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
    
    // TC : O(N) , as we are traversing the ll one time
    // SC : O(1) , no extra spaces are used
    
    public static void main(String args[]) {
        ListNode head = null;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        createCycle(head, 2, 3);
        
        // ListNode nodeRecieve = findStartingPointBf(head);
        ListNode nodeRecieve = findStartingPointOp(head);
        if(nodeRecieve == null) System.out.println("No cycle");
            else {
                ListNode temp = head;
                int pos = 0;
                while(temp!=nodeRecieve) {
                ++pos;
                temp = temp.next;
            }
            System.out.println("Tail connects at pos "+pos);
        }   
    }
}
