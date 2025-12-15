package com.example.linkedlist;

public class creationAndInsertion {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList(int nodeValue){
        head = new Node();
        Node node  = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int nodevalue,int location){
        Node node = new Node();
        node.value = nodevalue;
        if (head==null){
            createSingleLinkedList(nodevalue);
            return;
        }else if (location==0){
            node.next = head;
            head = node;
        }else if (location>size){
            node.next = null;
            tail.next = node;
            tail = node;
        }else {
            Node tempNode = head;
            int index = 0;

            while (index<location-1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }
    public void traverseLinkedList(){
        if (head==null){
            System.out.println("-1");
        }
        else {
            Node tempNode = head;
            for (int i=0;i<size;i++){
                System.out.print(tempNode.value);
                if (i!=size-1){
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
    }

    public static void main(String[] args) {
        creationAndInsertion ss = new creationAndInsertion();
        ss.createSingleLinkedList(5);
        ss.insert(9,0);
        ss.insert(18,1);
        ss.insert(27,2);
        ss.insert(36,3);
        ss.insert(45,4);
        ss.insert(54,5);
        ss.traverseLinkedList();
    }
}
