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

public class q3_sortTheLLOf0s1s2s {

    // Brute force approach

    // function to sort the ll of 0s , 1s  and 2s
    public static ListNode sortOf0s1s2sBf(ListNode head){
        int count0 = 0, count1 = 0, count2 =0;
        ListNode temp = head;
        while (temp!=null) {
            if (temp.data==0) {
                count0++;
            }else if(temp.data==1){
                count1++;
            }else{
                count2++;
            }
            temp = temp.next;
        }
        ListNode retemp = head;
        while (retemp!=head) {
            if (count0!=0) {
                retemp.data = 0; 
                retemp = retemp.next;
            }else if (count1!=1) {
                retemp.data = 1;
                retemp = retemp.next;
            }else{
                retemp.data = 2;
                retemp = retemp.next;
            }
        }
        return head;
    }
    
    // TC : O(2n) ,as we are traversing the entire ll twice .first one for check the counts and next one for data replacements 
    // SC : O(1) , no extra space is used 


    // optimal approach
    // function to sort the ll of 0s , 1s  and 2s
    public static ListNode sortOf0s1s2sOp(ListNode head){
        if (head==null || head.next==null) {
            return head;
        }
        // so first create the three dummy for each head
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // then assign the zero, one and two to the dummy node first
        ListNode zero = zeroHead , one = oneHead , two = twoHead;

        // traverse the ll
        ListNode temp = head;
        // if got it assign to the zero one and two
        while (temp!=null) {
            if (temp.data==0) {
                zero.next = temp;
                zero = temp;
            }else if (temp.data==1) {
                one.next = temp;
                one = temp;
            }else{
                two.next = temp;
                two = temp;
            }
        }
        // increase the temp to temp.next
        temp = temp.next;

        // if one.next will be not equal to null the next of zero will be one.next else it will be two.next
        zero.next = (one.next!=null) ? one.next : two.next;
        // next of one will be twoHead.next
        one.next = twoHead.next;
        // and next of two will be null
        two.next = null;

        // so now the newHead of the modified ll is 
        head = zeroHead.next;

        return head;


        // TC : nearly O(n) ,as i am travesing the elements only one time
        // SC  : O(1) , no extra spaces are used
    }
}