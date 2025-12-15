import java.util.Arrays;
import java.util.List;

public class q12_insertbeforeTheELementinLL  {

    public static Node insertAtVal(Node head,int el,int val){
        Node temp = head;
        Node prev = null;
        int count = 0;

        while (temp!=null) {
            if (temp.data==val) {
                Node newNode = new Node(el,temp);
                prev.next = newNode;
                break;
            }
            prev = temp;
            temp =temp.next;

        }
        return head;
    }


    //print the elements of the LL
    private static void printLL(Node head){
        while (head!=null) {
            System.out.print(head.data  + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        // Sample array, value, and position for insertion
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 5;
        int el = 3;

        // Creating a linked list with initial elements from the array
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        // Inserting a new node at position k in the linked list
        head = insertAtVal(head, el,val);

        // Printing the linked list
        printLL(head);
    }
}


//TC : O(n)  
//SC : O(1)