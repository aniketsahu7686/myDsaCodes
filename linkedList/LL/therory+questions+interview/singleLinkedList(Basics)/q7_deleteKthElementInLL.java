public class q7_deleteKthElementInLL {

    // function to delete the kth node in a linkedlist
    public static Node deleteK(Node head,int k){
        if(head==null){
            return null;
        }

        // if k is 1, delete the first element
        if(k==1){
            Node temp = head;
            head = head.next; 
            temp = null;
            return  head;
        }

        // traverse the list to find the kth node
        Node temp = head;
        Node prev = null;
        int count = 0;

        while (temp!=null) {
            count++;

            // if the kth node is found
            if (count==k) {
                // adjust the pointer to skip the next node
                prev.next = prev.next.next;
                // delete the kth node
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
        int k = 2;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        // Delete the k-th node in the linked list
        head = deleteK(head, k);

        // Print the modified linked list
        printLL(head);
    }
}



// TC : O(N) worst case, when deleting the tail and O(1) best case, when deleting the head.
// SC : O(1)