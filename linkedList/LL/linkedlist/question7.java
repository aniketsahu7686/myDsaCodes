package com.example.linkedlist;

//Remove duplicate element from unsorted Linked List

import java.util.HashSet;

public class question7 {
    public Node removeDuplicate(Node head){
        HashSet<Integer> ss = new HashSet<>();
        Node first = head;
        Node second = head.next;
        ss.add(first.value);
        while (second!=null){
            if (!ss.contains(second.value)){
                ss.add(first.value);
                first = first.next;
                second = second.next;
            }else {
                first.next = second.next;
                second = second.next;
            }
        }
        return head;
    }
}
