import java.util.HashMap;
import java.util.HashSet;
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
public class q2_detectACycleInLL {

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

    // function to detect the cycle using hashing
    public static boolean  detectCycleBf(ListNode head){
        HashSet<ListNode> hp = new HashSet<>();
        
        while (head!=null) {
            if (hp.contains(head)) {
                return false;
            }
            hp.add(head);
            head = head.next;
        }
        return true;
    } 

    // O(N) , the entire list is iterated once 
    // O(N) , all nodes present in the list are stored in a hash table 



    // function to detect the cycle using the fast and slow pointer approach
    public static boolean detectCycleOp(ListNode head){
        if ( head==null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast!=null || fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }

    // TC : O(N) , we are traversing the ll only one time
    // SC : O(1) , no extra spaces are used
    
    public static void main(String args[]) {
        ListNode head = null;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        createCycle(head,1,3);//creating cycle in the list
        if(detectCycleOp(head) == true)
        System.out.println("Cycle detected");
        else
        System.out.println("Cycle not detected");
        
    }
}
