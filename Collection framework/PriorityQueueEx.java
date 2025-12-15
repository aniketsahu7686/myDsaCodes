import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();


        // for adding the elements same as queue function
        pq.offer(40);        
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);

        // when we will print it will in the order of because byDefault integers
        // are arranged in the min heap order means min heap is implemented in priorityQueue
        // In Min heap the smallest element will be in the top of the data structure

        System.out.println(pq);

        pq.poll(); // it will return the min element , as they are arranged in  min heap

        System.out.println(pq);

        // so whenever we want to use the min heap in any question we can directly use the priorityQueue


        System.out.println(pq.peek());


        // now if we want the greater element 
        // means the priorityqueue should be in max heap order then it will return the greater element
        
        // this can be done by passing a compartor inside the constructor
        // Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    }
}
