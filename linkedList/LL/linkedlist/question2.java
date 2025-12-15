package com.example.linkedlist;
//Reverse a Linked List in groups of given size.

public class question2 {
    public static Node reversek(Node node,int k ){
        Node prev = null;
        Node curr = node;
        Node nextNode = null;

        int count=0;
        while (curr!=null && count<k){
             nextNode = node.next;
            node.next = prev;
            prev = curr;
            curr = nextNode;
            count++;
        }
        if (nextNode!=null){
            node.next = reversek(nextNode,k);
        }
        return prev;
    }

    public static void main(String[] args) {
        Node node = null;
    }
}
