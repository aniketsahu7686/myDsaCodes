 class Node {
    public int data;   // the data value;
    public Node next;   //the reference to the next element


    Node(int data1,Node  next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class q1_arrayToLinkedList{
    public static Node arrayToLL(int N,int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1;i<N;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }

        return head;
    }


    public static void main(String[] args){
        int[] arr = {2,5,8,9};
        Node head = arrayToLL(4, arr);
        System.out.println(head.data);
    }
}




/// Tc: O(n)  since we are iteratin over the entire array ,where n is the no of elements in the array
//  sc : O(1)  we have not used any extra space


