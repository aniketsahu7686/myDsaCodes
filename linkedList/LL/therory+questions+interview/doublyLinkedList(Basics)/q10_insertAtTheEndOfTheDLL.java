public class q10_insertAtTheEndOfTheDLL{
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

    // function to insert a node in the end of the DLL
    public static Node2 insertAtTheEnd(Node2 head,int value){

        // create a new node with data 'k'
        Node2 newlastNode = new Node2(value);

         // If the doubly linked list is empty, set 'head' to the new node
         if (head == null) {
            return newlastNode;
        }

        Node2 lastNode = head;


        //  traverse to the end of the dll
        while (lastNode.next!=null) {
            lastNode = lastNode.next;
        }


       // connect the new node with the last node in the list
       lastNode.next = newlastNode;
       

       // Return the new head
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


    public static void main(String[] args){
        int[] arr = {7,5,8,9};
        Node2 head = arrayToDLL(4, arr);
        printDLL(head);
        // System.out.println(head.data);
        head = insertAtTheEnd(head,3);
        printDLL(head);
    }
}

// TC: O(1) The time complexity of this insertion operation is O(1) because only a constant number of pointer updates are being
//  performed regardless of the size of the Doubly Linked List.

// SC: O(1)  The space complexity is also O(1) because a constant amount of extra space is used to create the new node.

