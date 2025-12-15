import java.util.ArrayList;

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

public class q2_segregateAllTheOddAndEvenNodes {

    // Brute force approach

    // function to segregate the odd then even nodes in the LL 
    public static ListNode oddEvenListBfApp(ListNode head){
        if (head==null || head.next==null) {
            return head;
        }

        // create an arraylist to store the elements in the order of odd and then even
        ArrayList<Integer> list = new ArrayList<>();

        // conditions for traversing the ll and store it in the ll for odd indexes
        ListNode temp1 = head;
        while (temp1!=null && temp1.next!=null) {
            list.add(temp1.data);
            temp1 = temp1.next.next;
        }
        if(temp1!=null) list.add(temp1.data);
        ListNode temp2 = head.next;
        // conditions for traversing the ll and store it in the ll for odd indexes
        while ( temp2!=null && temp2.next!=null) {
            list.add(temp2.data);
            temp2 = temp2.next.next;
        }
        if(temp2!=null) list.add(temp2.data);

        // condition for the replacements of the data
        ListNode temp = head;
        while (temp!=null) {
            for(int i=0;i<list.size();i++){
                temp.data = list.get(i);
                temp = temp.next;
            }
        }
        return head;
    }

    //TC :  O(2n) , first while loop to seperate the odd elements (n/2) next while loop to seperate the even elements (n/2) both 
    //            together added upto to O(n) to segregate them into an array and then another while loop for replacing the data
    //            O(n) . so in total that is O(2n)
    // SC : O(n) , as we are using an external data structure (Arraylist) to store the array 




    // optimal approach

    // function to segregate the odd then even nodes in the LL 
    public static ListNode oddEvenList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        // firstly store the head of the even index so that the last index of odd can connect easily
        ListNode evenHead = head.next;
        ListNode odd = head , even = head.next;
        // traversing the array
        while (even!=null && even.next!=null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        // connect the last index of the odd indexes to the first index of the odd indexes 
        odd.next = evenHead; 
        return head;
    }

    // TC :  O(n) , as O(n/2) for travering the odd indexes to connect and O(n/2) for traversing the even indexes to connect so 
    //        total is not equal but equivalent to O(n)
    // SC : O(1) , no extra space is used
    
}