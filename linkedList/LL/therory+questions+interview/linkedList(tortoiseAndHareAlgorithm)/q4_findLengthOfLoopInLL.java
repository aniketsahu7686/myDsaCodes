import java.util.HashMap;

public class q4_findLengthOfLoopInLL {
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

    // Brute force Approach (using Hashing)
    public static int findLengthOfLoopbf(ListNode head){
        // create a hashmap to store 
        HashMap<ListNode,Integer> hp = new HashMap<>();
        ListNode temp = head; 
        // set the timer to 1 
        int timer = 1;
        while (temp!=null) {
            // if the hashmap contains the node 
            if (hp.containsKey(temp)) {
                // get the key of the node
                int value = hp.get(temp);
                // subtract 
                return timer - value;
            }
            // if the hashmap doesn't contains the node add it by assigning the timer to it
            hp.put(temp, timer);
            // incremen the timer
            timer++;
            temp = temp.next;
        }
        // if it is reaching null that means it is a linear linkedlist and return 0
        return 0;
    }    
    // TC : O(N * 2 log n)  , O(N) to traverse the entire linkedlist , 2 * log n for the operations included in it
    // SC : O(N) ,  as we are using the hashmap for storing the nodes with its key (timer)



    // optimal approach (using the slow and fast pointer)
    public static int  findLengthOfLoopOpt(ListNode head){
        ListNode slow = head, fast = head;
        while (fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                return findLength(slow,fast);
            }
        }
        return 0;

    }
    private static int  findLength(ListNode slow,ListNode fast){
        int count = 1;
        fast = fast.next;
        if (slow!=fast) {
            count++;
            fast =fast.next;
        }
        return count;
    }

    // TC : O(n) + Loop length , as O(n)  for travesing the ll one time plus the length of the loop as it agains traverse to count 
    //        the length
    // SC : O(1) , no extra spaces are used 

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
        createCycle(head, 2, 9);
        
        // ListNode nodeRecieve = findStartingPointBf(head);
        // int length = findLengthOfLoopBf(head);
        int length = findLengthOfLoopOpt(head);
        System.out.println(length);
        
    }
}
