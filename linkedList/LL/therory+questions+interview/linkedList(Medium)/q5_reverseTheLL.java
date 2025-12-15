import java.util.List;
import java.util.Stack;

class ListNode  {
    int data;
    ListNode next;
    // create three constructors
    // 1
    ListNode(){}
    //2
    ListNode(int data){
        this.data = data;
    }
    //3
    ListNode(ListNode next,int data){
        this.data = data;
        this.next = next;
    }
}

public class q5_reverseTheLL {
    // function to convert the array to the ll
    public static ListNode arrayToLL(int N,int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for(int i=1;i<N;i++){
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }

        return head;
    }
     //function to print the LL
     private static void printLL(ListNode head){
        ListNode temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
     }

    // brute force approach
    public static ListNode reverseTheLLBf(ListNode head){
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;

        while (temp!=null) {
            st.push(temp.data);
            temp = temp.next;
        }
        ListNode newtemp = head;
        while (newtemp!=null) {
            newtemp.data = st.pop();
            newtemp = newtemp.next;
        }
        return head;
    }

    // TC : O(2N),  as we are using the first while to travere the ll and store it in the stack , and the other while to replace the 
    //        nodes in the ll from the stack
    // SC : O(N) ,  as we are using a data structure stack to store the elements


    // optimal approach

    // function to reverse the ll
    public static ListNode reverseTheLLOa(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        while (temp!=null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // TC : O(N) , as we are traversing the ll only one time
    // SC : O(1) , as we are not using any extra space


    // approach using recursion
    
    // function to reverse the ll
    public static ListNode reverseTheLLRec(ListNode head){
        if (head==null || head.next==null) {
            return head;
        }
        ListNode newHead = reverseTheLLRec(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    // TC : O(N) ,as we are travesing through the nodes (four recusion calls)
    // SC : O(n) , this will be recursive stack space (for the intial approaches)

    

    public static void main(String[] args){
        int[] arr = {2,5,8,9};
        ListNode head = arrayToLL(4, arr);
        arrayToLL(4, arr);
        printLL(head);

        // head = reverseTheLLBf(head);
        // head = reverseTheLLOa(head);
        head = reverseTheLLRec(head);
        printLL(head);
    }
}
