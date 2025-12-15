import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        // The line Queue<Integer> queue = new LinkedList<>(); means:
        // Queue<Integer> queue: Create a variable named queue that can hold a queue of integers.
        // new LinkedList<>();: Initialize this queue using a LinkedList, which is a specific type of queue.
        // In simple terms:
        // You're making a queue to store integers.
        // You're using a LinkedList to manage this queue because LinkedList can work as a queue.
        Queue<Integer> queue  = new LinkedList<>();

        // to add an element 
        queue.offer(12);
        queue.offer(24);
        queue.offer(36);


        // to remove an element
        queue.poll();

        // to return the top element in the queue
        queue.peek();

        

        // we can also use the linkedlist in the list interface 
        // by just using linkedlist in place of arraylist
    }
}
