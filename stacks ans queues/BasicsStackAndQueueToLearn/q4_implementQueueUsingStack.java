package BasicsStackAndQueueToLearn;
import java.util.Stack;

class MyQueue1 {
     // solution - 1:
     Stack<Integer> input = new Stack<>();
     Stack<Integer> output = new Stack<>();
 
     // initialize your data structure here :
     public MyQueue1(){

     }


    //  public String size() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'size'");
    // }


    //push element x to the back of the queue
     public void push(int x){
        // send all the elements  from the stack 1 to stack 2 :
        while (input.empty()==false) {
            output.push(input.peek());
            input.pop();
        }
        // now push the element x in the  input stack
        input.push(x);

        // now pop out the elements from the output stack and push them back into the input stack
        while (output.empty()==false) {
            input.push(output.peek());
            output.pop();
        }
     }


     // removes the element from in front of queue and return the element
     public int pop(){
        // shift input to ouptut
        if (input.empty()) {
            System.out.println("Stack is empty ");
        }
        int val = input.peek();
        input.pop();
        return val;
     }


     // get the front element
     public int peek(){
        // shift input to output
        if (input.empty()) {
            System.out.println("Stack is empty ");
        }

        return input.peek();
     }
}

// Time Complexity: O(N )  
// Space Complexity: O(2N)

class MyQueue2{
    // intialize two stacks
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();


    public MyQueue2(){

    }

    public void push(int x){
        input.push(x);
    }

    public int pop(){
       // shift input to output :
       if (output.empty()) {
        while (input.empty()==false) {
            output.push(input.peek());
            input.pop();
        }
       }

       int x = output.peek();
       output.pop();
       return x;
    }

    public int peek(){
        // shift input to output :
        if (output.empty()) {
            while (input.empty()==false) {
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }

    int size(){
        return (output.size() + input.size());
    }

}


public class q4_implementQueueUsingStack {
    public static void main(String[] args) {
    //  MyQueue1 queue = new MyQueue1();
    MyQueue2 queue = new MyQueue2();
     queue.push(3);
     queue.push(4);
     System.out.println("The element poped is : " + queue.pop());
     queue.push(5);
     System.out.println("The top element is " + queue.peek());
     System.out.println("The size of the queue is " + queue.size());
    }
 }