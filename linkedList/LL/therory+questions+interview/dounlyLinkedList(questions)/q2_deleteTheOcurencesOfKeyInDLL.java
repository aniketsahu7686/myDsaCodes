public class q2_deleteTheOcurencesOfKeyInDLL {
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
        System.out.println();
    }


    // function to delete the occurences of a given key in a DLL
    public static Node2 deleteTheOccurences(Node2 head,int key){
        Node2 temp = head;
        // traverse the ll
        while(temp!=null&& temp.next!=null) {
            // if the temp is the key  set the head to next of the  current head
            if (temp.data==key) {
                if (temp==head) {
                    head = head.next;
                }
                // set the value of the prevnode and nextnode
                Node2 nextNode = temp.next;
                Node2 prevNode = temp.back;
                
                // this is the important step where  we will check the prevNode and the nextNode 
                if (prevNode!=null) {
                     prevNode.next  = nextNode;
                }
                if (nextNode!=null) {
                    nextNode.back = prevNode;
                }

                temp = nextNode;
            }
            else{
                temp = head.next;
            }
        }
        return head;
    }


    public static void main(String[] args){
        int[] arr = {7,8,9,7,6,2,7,5,8,9};
        Node2 head = arrayToDLL(10, arr);
        // System.out.println(head.data);
        head = deleteTheOccurences(head, 7);
        printDLL(head);
    }
}

