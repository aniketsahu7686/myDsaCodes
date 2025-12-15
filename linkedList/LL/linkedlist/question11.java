package com.example.linkedlist;

//intersection of two sorted linked lists

public class question11 {
    public static Node intersectionPoint(Node head1,Node head2){
        if (head1==null || head2==null){
            return null;
        }
        Node result = null;
        Node prev = null;
        Node currnode1 = head1;
        Node currnode2 = head2;
        while (currnode1!=null && currnode2!=null){
//            if (currnode1.value==currnode2.value){
//                Node newnode = new Node(currnode1.value);
//                if (result==null){
//                    result = newnode;
//                }else {
//                    prev.next = newnode;
//                }
//                currnode1 = currnode1.next;
//                currnode2 = currnode2.next;
//                prev = newnode;
//            }else if (currnode1.value<currnode2.value){
//                currnode1 = currnode1.next;
//            }else {
//                currnode2 = currnode2.next;
//            }
        }
        return result;
    }
}
