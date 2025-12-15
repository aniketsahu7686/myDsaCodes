public class  q9_insertBeforeAGivenNodeInDLL{
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

    // function to insert a node in the head of the DLL
    public static Node2 insertAtHead(Node2 head,int value){
        // Create new node with data as val
       Node2 newHead = new Node2(value,head,null);

       // Set old head's back pointer to the new Head
       head.back = newHead;

       // Return the new head
       return newHead;
    }

    // function to insert an element before a node in dll
    public static void insertBeforeTheNode(Node2 node ,int value){
        // store the prevs element
        Node2 prev = node.back;

        // create a new node with the given value
        Node2 newNode2 = new Node2(value,node,prev);

        // connect the new node the dll
        prev.next = newNode2;
        node.back = newNode2;
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
        insertBeforeTheNode(head.next,10);
        printDLL(head);
    }
}

// TC: O(1) The time complexity of this insertion operation is O(1) because only a constant number of pointer updates are being
//  performed regardless of the size of the Doubly Linked List.

// SC: O(1)  The space complexity is also O(1) because a constant amount of extra space is used to create the new node.

