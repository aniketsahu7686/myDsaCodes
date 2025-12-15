package com.example.linkedlist;

//Find first node of loop in a linked list
public class question5 {
    public static Node detectFirstNode(Node head){
        Node slow = head;
        Node fast  = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        }while (fast!=slow);

        fast = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }



}
