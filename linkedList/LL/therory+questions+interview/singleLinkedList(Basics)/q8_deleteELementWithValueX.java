public class q8_deleteELementWithValueX {

    // function to delete the kth node in a linkedlist
    public static Node deleteK(Node head,int value){
        if(head==null){
            return null;
        }

        // if head  is the value in first, delete the first element
        if(head.data==value){
            Node temp = head;
            head = head.next; 
            temp = null;
            return  head;
        }

        // traverse the list to find the value
        Node temp = head;
        Node prev = null;
        

        while (temp!=null) {
          

            // if the value node is  found
            if (temp.data ==value) {
                // adjust the pointer to skip the next node
                prev.next = prev.next.next;
                // delete the value node
                temp = null;
                break;
            }
            // move to the next node
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    // function to print the ll
    static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        // Create a linked list
        int[] arr = {0, 1, 2};
        int value = 2;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        // Delete the k-th node in the linked list
        head = deleteK(head, value);

        // Print the modified linked list
        printLL(head);
    }
}


// TC :  O(N)
// SC : O(1)

