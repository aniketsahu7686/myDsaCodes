package august;

import java.util.ArrayList;
import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class q7_reverseTheLLuptoK {

    static Node head;

    // function to append a new node at the end
    public static void append(int data){
        if (head==null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    // function to reverse the k nodes in the linekd list
    public static Node reverseKNode(Node head,int k){
        if (head==null) {
            return null;
        }

        Node curre
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int x;


        while ((x=sc.nextInt())!=1) {
            arr.add(x);
        }
        
        int k = sc.nextInt();

        for(int val:arr){
            append(val);
        }

        // reverse the k nodes
        head = reverseKnodes(head,k);
    }
}
