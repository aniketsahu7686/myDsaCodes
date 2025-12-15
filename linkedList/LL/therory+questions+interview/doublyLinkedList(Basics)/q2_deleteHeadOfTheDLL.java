
public class q2_deleteHeadOfTheDLL {
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
        head = deleteHeadDLL(head);
        printDLL(head);
    }
}



// TC: O(1), Removing the head node from a doubly linked list is a constant-time operation, independent of the list’s size, 
// as it involves updating references to the head and the new head.

// SC: O(1) The space complexity for deleting the head of a doubly linked list is also O(1). This operation requires only a few
//  additional pointers, which are constant in number and do not depend on the list’s size.