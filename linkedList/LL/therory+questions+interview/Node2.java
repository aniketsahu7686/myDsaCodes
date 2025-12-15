// This one is for doubly linked list

public class Node2{
    public int data;
    public Node2 next;
    public Node2 back;


    Node2(int data1,Node2 next1,Node2 back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node2(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
    public static void main(String[] args){
        int[] arr = {2,5,8,7};
        Node2 y =  new Node2(arr[0]);
        System.out.println(arr[0]);
       }
}