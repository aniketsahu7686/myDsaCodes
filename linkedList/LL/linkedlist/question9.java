package com.example.linkedlist;

//Add 1 to a number represented as linked list

public class question9 extends question8 {

    public Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next;

        while (current!=null){
           next = current.next;
            current.next=prev;
            prev = current;
            head = next;
        }
        return prev;
    }
    public Node addOne(Node head){
        head = reverse(head);
        Node current = head;
        int carry = 1;
        while (carry==1){
            current.value +=1;
            if (current.value<10) return reverse(head);
            else current.value=0;
            if (current.next ==null) break;
            else current = current.next;
        }
        return reverse(head);
    }

    public static void main(String[] args) {
        question9 llist = new question9();

        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println(
                "Linked List before adding 1 ");
        llist.printList();
        llist.addOne(llist.head);
        System.out.println(
                "Linked List after adding 1 ");
        llist.printList();
    }

}
