import java.util.ArrayDeque;

public class ArrayDequeEx {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();


        // same as queue function
        adq.offer(58);

        // own functions are

        // it add elements in the first
        adq.offerFirst(89);

        // it add elements in the last
        // this is same as adq.offer()
        adq.offerLast(59);


        // here we can also implement the peek and poll function along with the peelLast,peelFirst,pollFirst,pollLast
        System.out.println(adq.peek());
        System.out.println(adq.peekFirst()); // this is same as peek()
        System.out.println(adq.peekLast());


        System.out.println(adq.poll());
        System.out.println(adq.pollFirst()); // this is same as poll()
        System.out.println(adq.peekLast());      
    }
}
