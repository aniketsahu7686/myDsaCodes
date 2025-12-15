import java.util.HashSet;
import java.util.List;

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
public class q8_findIntersectionPointOfTwoLL {
    //  function to insert node at the end of the linked list
    static ListNode insertNode(ListNode head,int val) {
        ListNode newNode = new ListNode(val);
    
        if(head == null) {
           head = newNode;
           return head;
        }
    
        ListNode temp = head;
        while(temp.next != null) temp = temp.next;
    
        temp.next = newNode;
        return head;
    }

    //utility function to print linked list created
        static void printList(ListNode head) {
            while(head.next != null) {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
        }

    // brute force approach     
    public static ListNode findIntersectionPointBf(ListNode head1,ListNode head2){
        while (head2!=null) {
            ListNode temp = head1;
            while (temp!=null) {
                // if both nodes are same and this is the intersection point 
                if (temp==head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        // intersection is not present between the ll 
        return null;
    }    

    // TC : O(M * N) , for each node of list 2 entire list1 is iterated 
    // SC : O(1) , no extra spaces is used 
    
    
    // next approach
    // Hashing
    public static ListNode findIntersectionPointByHasing(ListNode head1,ListNode head2){
        // first create a  data structure to store the node
        HashSet<ListNode> st = new HashSet<>();
        // insert the nodes of the linked list 1 in the hashset
        while (head1!=null) {
            st.add(head1);
            head1 = head1.next;
        }
        // check if the nodes of the linked list 2 is present in the hashset or not
        while (head2!=null) {
            if (st.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }
    // TC : O(n+m) ,  Iterating through list 1 first takes O(n), then iterating through list 2 takes O(m) 
    // SC : O(N) , Storing linked list 1 node address in HashSet 




    // next approach
    // differnce in length
    public static int differnceOfhead1Ans2(ListNode head1,ListNode head2){
        int length1 = 0,length2 = 0;
        ListNode temp1 = head1,temp2 = head2;
        // check the length of the ll
        while (temp1!=null || temp2!=null) {
            if (temp1!=null) {
                length1++;
                temp1 = temp1.next;
            }if (temp2!=null) {
                length2++;
                temp2 = temp2.next; 
            }
        }
        return length1-length2;
    } 
    public static ListNode  findIntersectionPointdiffInLength(ListNode head1,ListNode head2){
        int diff = differnceOfhead1Ans2(head1, head2);
        // if diff is smaller than 0 move the head2 to the next and continues as diff will be in negative
        if (diff<0) {
            while (diff++!=0) {
                head2 = head2.next;
            }
        }
        // if diff is smaller greater than 0 move the head1 to the next and continues
        else{
            while (diff--!=0) {
                head1 = head1.next;
            }
        }
        // check if there is any common intersection point or not 
        while (head1!=null) {
            if (head1==head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    // TC : O(2max(length of list1,length of list2))+O(abs(length of list1-length of list2))+O(min(length of list1,length of list2))
            // Reason: Finding the length of both lists takes max(length of list1, length of list2) because it is found simultaneously
            //  for both of them. Moving the head pointer ahead by a difference of them. The next one is for searching.

    // SC : O(1) , no extra space is used 

     
    // optimal approach
    public static ListNode  findIntersectionPointOpt(ListNode head1,ListNode head2){
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1 != temp2) {
            temp1 = temp1 == null? head2:temp1.next;
            temp2 = temp2 == null? head1:temp2.next;
        }
        return null;
    }

    //TC :O(2*max(length of list1,length of list2)), Uses the same concept of the difference of lengths of two lists.
    // SC : O(1) no extra spaces is used
    

    public static void main(String args[]) {
        // creation of both lists 
        ListNode head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        ListNode head1 = head;
        head = head.next.next.next;
        ListNode headSec = null;
        headSec=insertNode(headSec,3);
        ListNode head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        // ListNode answerNode = findIntersectionPointBf(head1,head2);
        // ListNode answerNode = findIntersectionPointByHasing(head1,head2);
        ListNode answerNode = findIntersectionPointdiffInLength(head1,head2);
        if(answerNode == null)  
        System.out.println("No intersection\n");
        else
        System.out.println("The intersection point is "+answerNode.data);
    }
}