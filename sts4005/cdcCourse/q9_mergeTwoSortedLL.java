import java.util.*;
 
class Node {
    int data;
    Node next;
 
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
 
class LinkedList {
    Node head;
 
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
 
    static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;
 
        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.insert(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insert(current2.data);
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            mergedList.insert(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            mergedList.insert(current2.data);
            current2 = current2.next;
        }
        return mergedList;
    }
 
    String getSortedElements() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        return result.toString().trim();
    }
}
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        LinkedList list1 = new LinkedList();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list1.insert(data);
        }
 
        int m = scanner.nextInt();
        LinkedList list2 = new LinkedList();
        for (int i = 0; i < m; i++) {
            int data = scanner.nextInt();
            list2.insert(data);
        }
 
        LinkedList mergedList = LinkedList.mergeSortedLists(list1, list2);
        System.out.println(mergedList.getSortedElements());
 
        scanner.close();
    }
}