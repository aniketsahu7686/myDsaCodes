
class Node {
    int data;   // the data value;
    Node next;   //the reference to the next element


    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }

   public static void main(String[] args){
    int[] arr = {2,5,8,7};
    Node y =  new Node(arr[0]);
    System.out.println(arr[0]);
   }
}
public class q9_insertAtTheHeadOfLL {
    

     // function to print the LL
    private static void printLL(Node head){
        while (head!=null) {
            System.out.print(head.data  + " ");
            head = head.next;
        }
    }

   // function to insert a new node at the head of the LL
    public static Node insertAtHead(Node head,int value){
         Node temp = new Node(value,head);
         return temp;
    }
    
    public static void main(String[] args) {
        // Create a linked list
        int[] arr = {0, 1, 2};
        int value = 5;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        // insert the value at the head of the linked list
        head = insertAtHead(head, value);

        // Print the modified linked list
        printLL(head);
    }
}
