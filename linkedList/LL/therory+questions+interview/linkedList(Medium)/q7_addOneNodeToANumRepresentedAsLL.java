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
public class q7_addOneNodeToANumRepresentedAsLL {

    // Brute force approach
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
     // function to add 1 to a single ll
    public static ListNode addOneToLLBf(ListNode head){
        // first reverse the ll
        reverseTheLLRec(head);
        // intialize the carry to 1 as initial , as we have to add only one 
        int carry = 1;
        ListNode temp = head;
        while (temp!=null) {
            temp.data = temp.data+carry;
            if (temp.data<10) {
                carry = 0;
                break;
            }else{
                temp.data=0;
                carry = 1;
            }
            temp = temp.next;
        }
        // if at the end the carry is 1 , then i need a  new node
        if (carry==1) {
            ListNode newNode = new ListNode(1);
            head = reverseTheLLRec(head);
            newNode.next = head;
            return newNode;
        }
        // what if carry is not 1 , simply end up by reversing the ll
        head = reverseTheLLRec(head);
        return head;
    }

    // TC : O(3N) ,as the first reversal will take O(N) , and the next traversal will take O(N) , and again we have to reverse the LL
    // SC : O(1) , no extra spaces are used 

    

     // optimal approach
    // function to add one to a single ll
    // this time we have to add 1 to ll without reversing the ll , so for that we can use the recursion as it involves backtracking
    // public static ListNode addOneToLLOp(ListNode head){
    //     // this carry will be the final carry , depending on this we will decide we will add a new node or not
    //     ListNode carry = helper(head);
    //     if (carry==1) {
    //         ListNode newNode = new ListNode(1);
    //         newNode.next = head;
    //         return newNode;
    //     }
    // }
    // public static ListNode helper(ListNode head){
    //     ListNode temp = head;
    //     if (temp==null) {
    //         return 1 ;
    //     }
    //     carry = helper(temp.next);
    //     temp.data = temp.data+carry;

    //     if (temp.data<10) {
    //         return 0;
    //     }
    // }

    public static void main(String[] args){
        int[] arr = {2,5,8,9};
        ListNode head = arrayToLL(4, arr);
        printLL(head);
        head = addOneToLLBf(head);
        printLL(head);
    }
}
