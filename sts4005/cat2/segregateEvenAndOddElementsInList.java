package cat2;
import java.util.*;

public class segregateEvenAndOddElementsInList {
    ListNode1 head; // head of the linkedlist
    
    static class ListNode1{
        int data;
        ListNode1 next;
        ListNode1(int val){
            data = val;
            next = null; 
        }
    }

    public void segregateEvenOdd(){
        ListNode1 evenStart = null;
        ListNode1 evenEnd = null;
        ListNode1 oddStart = null;
        ListNode1 oddEnd = null;
        ListNode1 currentNode = head;

        while (currentNode!=null) {
            int element = currentNode.data;

            if (element%2 == 0) {
                if (evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                }else{
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            }else{
                if (oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                }else{
                    oddStart.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }

            // move the head pointer one step in forward direction
            currentNode = currentNode.next;
        }

        if (oddStart == null || evenStart==null) {
            return;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
    }
     void push(int newdata) 
    { 
        /* 1 & 2: Allocate the ListNode1 & 
                  Put in the data*/
        ListNode1 newnode = new ListNode1(newdata); 
   
        /* 3. Make next of new ListNode1 as head */
        newnode.next = head; 
   
        /* 4. Move the head to point to new ListNode1 */
        head = newnode; 
    } 

     void printList() 
    { 
        ListNode1 temp = head; 
        while(temp != null) 
        { 
            System.out.print(temp.data+" "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 

    public static void main(String[] args){
        segregateEvenAndOddElementsInList ll = new segregateEvenAndOddElementsInList();
        ll.push(11);
        ll.push(10);
        ll.push(9);
        ll.push(3);
        ll.push(6);
        ll.push(14);
        ll.push(1);
         
        ll.printList();
        ll.segregateEvenOdd();
        ll.printList();
    }

}
