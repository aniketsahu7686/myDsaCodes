import java.util.Arrays;
import java.util.List;

public class q10_insertAtTheEndOfTheLL {

    //print the elements of the LL
    private static void printLL(Node head){
        while (head!=null) {
            System.out.print(head.data  + " ");
            head = head.next;
        }
    }

    // function to add the element in the end of the linkedlist
    public static Node insertTail(Node head,int value){

        if (head==null) {
            return new Node(value);
        }

        
        Node temp = head;


        while (temp.next!=null) {
            temp = temp.next;
        }

        Node newNode = new Node(value);
        temp.next = newNode;

        return head;
    }

     public static void main(String[] args) {
        // Sample array and value for insertion
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int value = 100;

        // Creating a linked list with initial elements from the array
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        // Inserting a new node at the tail of the linked list
        head = insertTail(head, value);

        // Printing the linked list
        printLL(head);
    }
}
