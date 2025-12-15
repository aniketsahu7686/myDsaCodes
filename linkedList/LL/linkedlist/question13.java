package com.example.linkedlist;

import java.nio.file.NotDirectoryException;

public class question13 {
    public static Node getMid(Node head){
        if (head==null || head.next ==null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast!=null &&  fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static Node merge(Node head1,Node head2){
        Node res = new Node();
        Node tmp = res;
        while (head1!=null && head2!=null){
            if (head1.value==head2.value){
                tmp.next = head1;
                head1 = head1.next;
                tmp = tmp.next;
            }else {
                tmp.next = head2;
                head2 = head2.next;
                tmp = tmp.next;
            }
        }
        while (head1!=null && head2==null){
            tmp.next  = head1;
            head1 = head1.next;
            tmp = tmp.next;
        }
        while (head1==null && head2!=null){
            tmp.next = head2;
            head2 = head2.next;
            tmp = tmp.next;
        }
        return res.next;
    }
    static Node mergeSort(Node head){
        if (head==null || head.next==null){
            return head;
        }
        Node mid = getMid(head);
        Node midNext = mid.next;
        mid.next = null;
        Node nh1 = mergeSort(head);
        Node nh2 = mergeSort(midNext);
        Node nh = merge(nh1,nh2);
        return nh;
    }
}
