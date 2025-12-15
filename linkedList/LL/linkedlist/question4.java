package com.example.linkedlist;

//remove a cycle in a linkedlist
//first we will follow the same process but we will create a do while loop until the slow pointer match the fast pointer , and then we will point the fast pointer to head and slow pointer
//        to the node from where the loop starts and move one pointer each.The point at which fast and slow pointer meet each other then point the slow.next to null .

public class question4 {
    public static int removeCycle(Node head){
        Node slow = head;
        Node fast = head;
        do {
              fast = head.next.next;
              slow = head.next;
        }while (slow!=fast);

        fast = head;
        while (slow!=fast){
            slow = head.next;
            fast = head.next;
        }
        slow.next = null;
        return 1;
    }
}
