package BasicsStackAndQueueToLearn;
import java.util.Queue;
import java.util.*;

public class q3_implementStackUsingQueue {
   public static void main(String[] args) {
    stack st = new stack();
    st.push(3);
    st.push(2);
    st.push(4);
    st.push(1);
    System.out.println("Top of the stack : " + st.pop());
    System.out.println("Size of the stack before removing element : " + st.size());
    System.out.println("The deleted element is :" + st.pop());
    System.out.println("Top of the stack after removing element : " + st.pop());
    System.out.println("Size of the stack after removing element :" + st.size());
   }
}
class stack{
    Queue<Integer> q = new LinkedList<>();
    void push(int x){
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());
        }
    }
    int pop(){
        return q.remove();
    }
    int top(){
        return q.peek();
    }
    int size(){
        return q.size();
    }
}


// Time Complexity: O(N)
// Space Complexity: O(N)



