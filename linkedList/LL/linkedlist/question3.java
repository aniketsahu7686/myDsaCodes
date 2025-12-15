package com.example.linkedlist;

//floyd cycle detection algoritm: we will use two pointers which will go one forward at a time and the another will move two at time
//and if they meet at a point then the linkedlist contains  a loop
public class question3 {
    public static Node detectCycle(Node head){
        Node fast = head;
        Node slow = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if (slow==fast){
                return slow ;
            }
        }
        return null;
    }

}
