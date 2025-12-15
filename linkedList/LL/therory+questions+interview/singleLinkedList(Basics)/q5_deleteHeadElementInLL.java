public class q5_deleteHeadElementInLL {

    // Method to remove the head of the linked list
    public static Node removesHead(Node head){
        //check if the linkedlist is empty or not
        if (head==null) {
            return null;
        }
        // move the head to the next node
        head = head.next;
        // move the updated head of the linkedlist
        return head;
        // There’s no need to delete the earlier head since it gets automatically deleted.
    }

    // method to print the ll 
    public static void  printLL(Node head){
        Node temp = head;

        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        // Initialize an array with integer values
        int[] arr = { 2, 5, 8, 7 };
        // Create the linked list with nodes initialized with array values
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        // Remove the head of the linked list
        head = removesHead(head);
        // Print the modified linked list
        printLL(head);
    }
    
}
