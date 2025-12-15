public class q6_deleteLastElementInLL {
    //function to delete the tail of the linkedlist
     public static Node deleteTail(Node head){
        //check if the linkedlist is empty or having just one node
        if(head == null || head.next ==null){
            return null;
        }
        // create a temporary point for the travesal
        Node temp = head;
        // traverse the LL until the second-last-node
        while (temp.next.next!=null) {
            temp = temp.next;
        }
         // Nullify the connection from the second-to-last node to delete the last node
        temp.next = null;
        // return the updated head of the linekdlist
        return head;
     }

     //function to print the LL
     private static void printLL(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
     }
    public static void main(String[] args) {
        // Initialize an array with integer values
        int[] arr = {2, 5, 8, 7};
        // Create the linked list with nodes initialized with array values
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        // Delete the tail of the linked list
        head = deleteTail(head);
        // Print the modified linked list
        printLL(head);
    }
}


// TC :  O(n) , as we have to travese the whole LL at once
// SC : O(1) 
