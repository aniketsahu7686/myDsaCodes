import org.w3c.dom.Node;

public class q8_insertAtKthPositionInDLL {
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

    // function to insert the element in the kth position 
    public static Node2 insertAtKthPosition(Node2 head,int position,int value){

        if(position==1){
            // K = 1 means node has to be insert before the head
            return insertAtHead(head, value);
        }
        Node2 kthNode = head;
        int count = 0; // count so that kth element can be reached

        while (kthNode.next!=null) {
            count++;
            // on reaching the kth element break out from the loop
            if (count==position) {
                break;
            }

            // keep moving forward until count!=k
            kthNode = kthNode.next;
        }

        Node2 kthPrev = kthNode.back;
        // create a new node with data as value
        Node2 newNode = new Node2(value,kthNode,kthPrev);

        // join the new node pointers with the prev and temp
        kthPrev.next = newNode;
        kthNode.back = newNode;

        // return the head of the DLL
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
        head = insertAtKthPosition(head,3,10);
        printDLL(head);
    }
}

// TC:  O(K) The time complexity of this operation is O(K) in the worst case because it may involve traversing K nodes in the
//  Doubly Linked List to reach the Kth element. In the best case, when K is 0 (insertion at the head), the time complexity is O(1) 
//  as it involves a constant number of operations. In the average case, it’s O(K).

// SC: O(1)  The space complexity is also O(1) because a constant amount of extra space is used to create the new node.

