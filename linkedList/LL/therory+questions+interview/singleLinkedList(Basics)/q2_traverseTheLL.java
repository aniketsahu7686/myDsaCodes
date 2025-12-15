 class Node {
    int data;   // the data value;
    Node next;   //the reference to the next element


    Node(int data1,Node  next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }

   public static void main(String[] args){
    int[] arr = {2,5,8,7};
    Node y =  new Node(arr[0]);
    System.out.println(arr[0]);
   }
}

public class q2_traverseTheLL{
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

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
