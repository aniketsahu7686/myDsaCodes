package com.example.linkedlist;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.nio.file.NotDirectoryException;

//Add two numbers represented by linked lists
//   step 1 :  carry = 0;
//   step2 :  sum find;
//   step 3 : digit first digit  = sum%10;
//   step 4 : create node for the digit;
//   step 5 : then finds the carry  (carry = sum/10);
public class question10 {
    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }
        return prev;
    }
    public Node addTwoLists(Node first ,Node second){
        first = reverse(first);
        second = reverse(second);

        Node result=null;
        Node prev= null;
        int carry = 0;

        while (first!=null || second!=null){
            int sum = carry;
            if (first!=null){
                sum+=first.value;
                first = first.next;
            }
            if (second!=null){
                sum+=second.value;
                second = second.next;
            }
            carry=sum/10;
            sum = sum%10;
            Node newNode = new Node();

            if (result==null){
                result = newNode;
            }else {
                prev.next = newNode;
            }
        }
//        prev = newNode;

        if (carry>0){
//            prev.next = new Node(carry);
        }
        result = reverse(result);
        return result;
    }

    public static void main(String[] args) {

    }
}
