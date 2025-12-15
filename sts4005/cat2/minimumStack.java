package cat2;
import java.util.Stack;

 class MinStackSol {
    Stack<Long> st = new Stack<Long>();
    Long mini;

    // initialize your data stucture here 
    public MinStackSol(){
        mini = Long.MAX_VALUE;
    }

    public void push(int value){
        // it means convert the int value into long 
        Long val = Long.valueOf(value);
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        }else{
            if (val<mini) {
                st.push(2*val-mini);
                mini = val;
            }else{
                st.push(val);
            }
        }
    }

    public void pop(){
        if (st.isEmpty()) {
            return;
        }
        Long val = st.pop();
        if (val<mini) {
            mini = (2* mini) -val;
        }
    }
    public int top() {
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}



public class  minimumStack {
   public static void main(String[] args) {
    MinStackSol s = new MinStackSol();
   
    // Function calls
    s.push(3); 
    s.push(5);
    System.out.println(s.getMin());
    s.push(2);
    s.push(1);
    System.out.println(s.getMin());
    s.pop();
    System.out.println(s.getMin());
    s.pop();
    s.top();
   }

}
