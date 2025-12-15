public class q4_deleteTheKthNodeOfDLL {

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
    // function to delete the head of the doubly linked list
    public static Node2 deleteHeadDLL(Node2 head){
        // return null if the list is empty or contains only element 
        if (head==null || head.next==null) {
            return null;
        }

        Node2 prev= head;
        head = head.next;
        
        head.back = null; // set 'back' pointer of the new node to null
        prev.next = null; // set 'next' pointer of the prev node to null


        return head;
    }
    // function to delete the tail node of the dll
    public static Node2 deleteLastNodeDLL(Node2 head){

        if (head==null || head.next==null) {
            return null;  // return null if the list is empty or contains only the element
        }


        Node2 tail = head;
        while (tail.next!=null) {
            tail = tail.next;
        }

        Node2 newTail= tail.back;

        newTail.next = null;
        tail.back = null;

        return head;
    }

    // function to delete the kth element in DLL
    public static Node2 deleteKthNode(Node2 head,int k){

        if (head==null || head.next==null) {
            return null;
        }

        int count = 0;

        Node2 kthnode = head;
        while (kthnode!=null) {
            count++;
            if (count==k) {
                break;
            }
            kthnode = kthnode.next;
        }

        Node2 back = kthnode.back;  // for the prev node
        Node2 front = kthnode.next; // for the next node


        // if both are null it is a singly element doubly linkedlist
        if (back==null && front==null) {
            return null;
        }else if(back==null ){
            deleteHeadDLL(head);
        }else if(front==null){
            deleteLastNodeDLL(head);
        }

        back.next = front;
        front.back = back;


        kthnode.next = null;
        kthnode.back = null;


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
        head = deleteKthNode(head,3);
        printDLL(head);
    }
}



// TC: O(1) Removing a node of a doubly linked list is a quick operation, taking constant time because it only involves updating 
// references and is independent of the list’s length.

// SC: O(1) Deleting a node also has minimal memory usage, using a few extra pointers without regard to the list’s size hence constant 
// space complexity.


