public class q3lengthOfTheLL {
    public static int lengthOfThell(Node head){
        int count = 0;
        Node temp = head;

        while(temp!=null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,9,6};
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);


        System.out.println(lengthOfThell(head));
    }

}





// TC: O(n)   as we are iterating the entire list
// SC: O(n)   as we are not using any extra space 