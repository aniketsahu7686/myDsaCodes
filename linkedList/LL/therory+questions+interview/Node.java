
// This one is for single list list

 public class Node {
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


    public static void main(String[] args) {
        int[] arr = {2,5,8,7};
        Node y =  new Node(arr[0]);
        System.out.println(arr[0]);
    }
}


