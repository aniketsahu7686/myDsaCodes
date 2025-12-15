package com.example.linkedlist;

import java.nio.file.NotDirectoryException;

public class question18 {
    public static Node findMidddleElement(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return head;
    }
    public static Node reverseLinkedList(Node head,int k){
        Node prev = null;
        Node curr = head;
        Node nextNode = null;

        int count = 0;
        while (curr!=null && count<k){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = prev;
            count++;
        }
        if (nextNode!=null){
            curr.next = reverseLinkedList(nextNode,k);
        }
        return prev;
    }
//    public static boolean isPalindromeOrNot(Node head){
//        if (head==null || head.next==null){
//            return true;
//        }
//        Node mid = findMidddleElement(head);
//        Node last = reverseLinkedList(mid.next);

//        Node curr = head;
//        while (last!=null){
////            if (last.value!=null){
////                return false;
////            }
//            last = last.next;
//            curr = curr.next;
//        }
//        return true;
//    }
}
//