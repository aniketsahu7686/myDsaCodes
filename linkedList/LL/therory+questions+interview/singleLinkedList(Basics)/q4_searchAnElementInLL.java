public class q4_searchAnElementInLL {
    public static boolean searchElement(Node head,int target){
        Node temp = head;

        while(temp!=null){
            if(temp.data ==target) return true;
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,9,6};
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);


        System.out.println(searchElement(head,6));
    }

}




// TC : O(n) in the worst case , as we have to traverse every node of the linkedlist , whereas O(1) in the best case whenever
// we got the target  in the first element

// SC : O(1) 




