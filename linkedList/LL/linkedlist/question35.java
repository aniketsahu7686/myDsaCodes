package com.example.linkedlist;

public class question35 {
    public static Node getNthFromLast(Node head,int n){
        Node curr = head;
        Node nextcurr = head;
        for (int i=0;i<n;i++){
             nextcurr = head.next;
        }
        while (nextcurr!=null){
            curr = curr.next;
            nextcurr  = nextcurr.next.next;
        }
        return curr;
    }
}
