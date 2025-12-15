import java.util.Arrays;
import java.util.List;

public class q11_insertBeforeTheKthElemInLL {

    public static Node insertAtK(Node head,int value,int k){
        Node temp = head;
        Node prev = null;
        int count = 0;

        while (temp!=null) {
            count++;
            if (count==k-1) {
                Node newNode = new Node(value,temp.next);
                temp.next = newNode;
                break;
            }
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
        int val = 100;
        int k = 3;

        // Creating a linked list with initial elements from the array
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        // Inserting a new node at position k in the linked list
        head = insertAtK(head, val, k);

        // Printing the linked list
        printLL(head);
    }
}
