package com.example.linkedlist;

public class question34 {
    public static Node segregateNodes(Node head){
        Node oddfirst = null;
        Node oddend = null;
        Node evenfirst = null;
        Node evenend = null;

        Node curr = head;

        while (curr!=null){
            int x = curr.value;
            if (x%2==0){
                if (evenfirst==null){
                    evenfirst = curr;
                    evenend = curr;
                }else {
                    evenend.next = curr;
                    evenend = evenend.next;
                }
            }else {
                if (oddfirst==null){
                    oddfirst=curr;
                    oddend = curr;
                }else {
                    oddend.next = curr;
                    curr = oddend.next;
                }
            }
            curr = curr.next;
        }
        if (oddend!=null){
            oddend.next = null;
            if (evenfirst==null){
                evenfirst = oddfirst;
            }else {
                evenfirst.next = oddfirst;
            }
        }
        return evenfirst;
    }
}
