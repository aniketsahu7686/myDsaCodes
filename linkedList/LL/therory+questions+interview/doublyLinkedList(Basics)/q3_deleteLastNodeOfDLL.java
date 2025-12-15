public class q3_deleteLastNodeOfDLL {

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
        head = deleteLastNodeDLL(head);
        printDLL(head);
    }
}
