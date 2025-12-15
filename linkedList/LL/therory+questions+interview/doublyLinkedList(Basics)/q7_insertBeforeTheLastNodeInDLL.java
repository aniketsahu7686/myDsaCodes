public class q7_insertBeforeTheLastNodeInDLL {
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

    // function to insert a node in the front of the last node in  DLL
    public static Node2 insertBeforeLastNode(Node2 head,int value){

        // edge case if dll has only one elements
        if (head.next==null) {
            // if only element
            return insertAtHead(head, value);
        }


        // create pointer tail to traverse to the end of dll
       Node2 lastNode = head;
       while (lastNode.next!=null) {
        lastNode  = lastNode .next;
       }

       Node2 lastPrev = lastNode.back;
       // create a new node with value
       Node2 newNode = new Node2(value,lastNode,lastPrev);


       // join the new node in dll
       lastNode.back = newNode;
       lastPrev.next = newNode;
       
       // return the updated dll
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
        head = insertBeforeLastNode(head,3);
        printDLL(head);
    }
}

// TC: The time complexity of this insertion operation is O(n) because we have to traverse the entire list to reach i’s tail.
//  The complexity would be O(1) if we were given the tail node to start with. 

// SC: O(1)  The space complexity is also O(1) because a constant amount of extra space is used to create the new node.


