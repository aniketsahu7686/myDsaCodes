public class q5_deleteTheValueInDLL {
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
    public static void deleteValue(Node2 temp){
        Node2 front = temp.next;
        Node2 prev = temp.back;


        // if the temp is the tail node
        if (front==null) {
            prev.next = null;
            temp.back = null;
            return;
        }

        // disconnect temp from the dll
        prev.next = front;
        front.back = prev;

        // set's temp pointer to null
        temp.next = null;
        temp.back = null;


        // free memory of the deleted node
        return;
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
        deleteValue(head.next.next);
        printDLL(head);
    }
}


// NOTE : This question will never ask to delete the value at the head of the DLL because we have to move the head to the next node 
//        in which we have to write more conditions.



// TC O(1) Removing a node of a doubly linked list is a quick operation, taking constant time because it only involves updating 
// references and is independent of the list’s length.

// SC: O(1) Deleting a node also has minimal memory usage, using a few extra pointers without regard to the list’s size hence
//  constant space complexity.