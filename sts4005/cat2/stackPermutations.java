package cat2;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;


public class stackPermutations {
    public static boolean checkStackPermutation(Queue<Integer> input, Queue<Integer> output,int n){
        Stack<Integer> st = new Stack<>();

        while (!input.isEmpty()) {
            st.push(input.poll());

            while (!st.isEmpty() && st.peek().equals(output.peek())) {
                st.pop();
                output.poll();
            }
        }
        return (output.isEmpty() && st.isEmpty());
    }
    public static void main(String[] args)
    {
	Queue<Integer> input = new LinkedList<>();
	input.offer(1);
	input.offer(2);
	input.offer(3);
	Queue<Integer> output = new LinkedList<>();
	input.offer(2);
	input.offer(1);
	input.offer(3);
        int n = 3;
        if (checkStackPermutation(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
    }

}
