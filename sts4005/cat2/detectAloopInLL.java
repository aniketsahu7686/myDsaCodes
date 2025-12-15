package cat2;
import java.util.*;

public class detectAloopInLL {
    ListNode head;  // head of the linked list

    // here is thel linked list node
    static class ListNode{
        int val;
        ListNode next;
        // int flag; // only for the modification in Node Structure (method-3)
    
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public void push(int newdata){
        // allocate the Node and put in the data 
        ListNode newnode = new ListNode(newdata);
        // make next of new Node as head
        newnode.next = head;
        // move the head to point to new Node
        head = newnode;
    }

    // method 1 : 
    // so the method one is floyd cycle find
    public static boolean hasCycle1(ListNode head){
        if (head==null || head.next==null) {
            return false;  // no cycle if the list is empty or has only one node
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare!=null  && hare.next!=null ) {
            tortoise = tortoise.next;
            hare = hare.next;

            // if they meet there is a cycle
            if (hare==tortoise) {
                return true;
            }
        }
        return false;
    }
    // TC : O(N)
    // SC : O(1)


    // method 2:
    public static boolean hasCycle2(ListNode head){
        HashSet<ListNode> s = new HashSet<ListNode>();

        while (head!=null) {
            if(s.contains(head)){
                return true;
            }
            s.add(head);
            head = head.next;
        }
        return false;
    }
    // TC : O(N) , only one traversal of the loop 
    // SC : O(N) , space required to store the value in the HashMap


    // method-3
    // by modification in Node Structure 
    // public static boolean hasCycle3(ListNode head){
    //     while (head!=null) {
    //         if (head.flag==1) {  // here flag is intialized in extra in ListNode
    //             return true;
    //         }

    //         head.flag = 1;
    //         head = head.next;
    //     }
    //     return false;
    // }

    public static void main(String[] args){
        detectAloopInLL list = new detectAloopInLL();
        list.push(20);
        list.push(4);
        list.push(5);
        list.push(57);

        // create a loop for testing
        list.head.next.next.next.next = list.head;

        // boolean ans = hasCycle1(list.head);
        boolean ans = hasCycle2(list.head);
        System.out.println(ans);        
    }
}
