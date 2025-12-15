import java.sql.Time;
import java.util.Stack;

public class q1_reverseTheDLL {

    // function to convert the array to the doubly linked list
    public static Node2 arrayToDLL(int N,int[] arr){
        // intitial head
        Node2  head = new Node2(arr[0]);
        Node2 prev = head;

        for(int i=1;i<N;i++){
            Node2 temp = new Node2(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    // function to print the doubly linked list
    public static void printDLL(Node2 head){
        while ((head!=null)) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Bruteforce Approach
    // function to reverse the DLL in brute force Approach
    public static Node2 reverseTheDLLBf(Node2 head){
         // intialize the stack st 
         Stack<Integer> st = new Stack<>();

        Node2 temp = head;

        while (temp!=null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while(temp!=null){
            temp.data = st.pop();
            temp = temp.next;
        }

        return head;
    }
  
    // TC :  O(2N) During the first traversal, each node’s value is pushed into the stack once, which requires O(N) time. 
    // Then, during the second iteration, the values are popped from the stack and used to update the nodes.

    // SC : O(N) This is because we are using an external stack data structure. At the end of the first iteration, the stack
    //  will hold all N values of the doubly linked list therefore the space required for stack is directly proportional to the
    //   size of the input doubly linked list.


    // optimal Approach
    // function to reverse the DLL in brute force Approach
    public static Node2 reverseTheDLLOp(Node2 head){
        // check if the ll in empty or have only one element
        if (head==null || head.next==null) {
            // no change is needed , return the current head 
            return head;
        }
         // Initialize a pointer to
         // the previous node        
         Node2 prev = null;

         // Initialize a pointer to
        // the current node
        Node2 temp = head;

        // Traverse the linked list
        while (temp!=null) {
            // Store a reference to
            // the previous node
            prev = temp.back;

             // Swap the previous and
            // next pointers
            temp.back = temp.next;

            // This step reverses the links
            temp.next = prev;

             // Move to the next node
            // in the orignal list
            temp = temp.back;
        }
        return prev.back;
    } 


    // TC : O(N) We only have to traverse the doubly linked list once, hence our time complexity is O(N).

    // SC: O(1), as the reversal is done in place.

    public static void main(String[] args){
        int[] arr = {7,5,8,9};
        Node2 head = arrayToDLL(4, arr);
        // System.out.println(head.data);
        printDLL(head);

        // head = reverseTheDLLBf(head);
        // printDLL(head);

         head = reverseTheDLLOp(head);
        printDLL(head);
    }
}
