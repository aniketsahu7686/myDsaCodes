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
public class q1_addTwoNoReprAsLL {
    // function to add the two no in LL which are in reverse order
    public static ListNode addTwoNoInLL(ListNode l1, ListNode l2)   {
        // first create a dummy node which will point to the head
        ListNode dummyNode = new ListNode();
        // then initialize the temp to the dummyNode
        ListNode temp  = dummyNode;
        int carry = 0;

        while (l1!=null || l2!=null || carry==1 ) {
            int sum = 0;
            if (l1!=null) {
                sum = sum+l1.data;
                l1 = l1.next;
            }
            if (l2!=null) {
                sum = sum + l2.data;
                l2 = l2.next;
            }


            sum += carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummyNode.next;
    }    
}

// TC : O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n)
//  times.

// SC : O(max(m,n)). The length of the new list is at most max(m,n)+1.