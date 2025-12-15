import java.util.ArrayList;
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

public class q6_checkIfTheLLisPalindromeOrNot {
    // function to insert the node
    static ListNode  insertNode(ListNode head,int val) {
        ListNode newNode = new ListNode(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        } 
        
        temp.next = newNode;
        return head;
    }

    // Brute force approach
    // function to check if the ll is palindrome or not
    public static boolean llPalindromeOrNotbF(ListNode head){
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp!=null) {
            arr.add(temp.data);
            temp = temp.next;
        }
        for(int i=0;i<arr.size()/2;i++){
            if (arr.get(i)!=arr.get(arr.size()-i-1)) return false;
        }
        return true;
    }

    // TC : O(N) , Iterating through the list to store elements in the array.
    // SC : O(N) , Using an array to store list elements for further computations.

    

    // Optimal Approah
    // function to check if the ll is palindrome or not
    public static boolean llPalindromeOrNotoP(ListNode head){
        if (head==null || head.next==null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null &&  fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow =  slow.next;
        ListNode dummy  = head;

        while (slow!=null) {
            if (dummy.data!=slow.data) {
                return false;
            }
            dummy = dummy.next;
            slow =slow.next;
            
        }
        return true;
    }
    static ListNode reverse(ListNode ptr) {
        ListNode pre=null;
        ListNode nex=null;
        while(ptr!=null) {
            nex = ptr.next;
            ptr.next = pre;
            pre=ptr;
            ptr=nex;
        }
        return pre;
    }


    // TC :  O(N/2)+O(N/2)+O(N/2), O(N/2) for finding the middle element, reversing the list from the middle element, and
    //          traversing again to find palindrome respectively.
    // SC : O(1) , no extra spaces are used 

    public static void main(String[] args){
        ListNode head = null;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,2);
        head=insertNode(head,1);
        // if(llPalindromeOrNotbF(head)==true)
        // System.out.println("True"); 
        // else
        // System.out.println("False");
          if(llPalindromeOrNotoP(head)==true)
        System.out.println("True"); 
        else
        System.out.println("False");

    }
}