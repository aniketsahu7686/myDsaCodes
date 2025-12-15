public class q4_removesDuplicatesFromASortedDLL {
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
    // function to print the doubly linked list
    public static void printDLL(Node2 head){
        while ((head!=null)) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // function to remove the duplicates of a sorted DLL
    public static Node2 removeDupOfDLL(Node2 head){
        Node2 temp = head;
        while (temp!=null && temp.next!=null) {
            Node2 newNode;
            Node2 nextNode = temp.next;
            while (nextNode!=null && nextNode.data==temp.data) {
                newNode = nextNode.next;
            }
            temp.next = nextNode;
            // if (nextNode!=null) {
                // newNode.back = temp;
            // }
            temp = temp.next;
        }
        return head;
    }


    public static void main(String[] args){
        int[] arr = {7,5,8,9};
        Node2 head = arrayToDLL(4, arr);
        // System.out.println(head.data);
        printDLL(head);
    }
}

