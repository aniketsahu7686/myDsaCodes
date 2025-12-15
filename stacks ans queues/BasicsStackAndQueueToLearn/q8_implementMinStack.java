package BasicsStackAndQueueToLearn;
  import java.util.Stack;
  
  // solution 1 : Using pairs to store the value and minimum element till now
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    class MinStackSol1{
        Stack<Pair> st;
        public MinStackSol1(){
            st = new Stack <>();
        }

        public void push(int x){
            int min;
            if (st.isEmpty()) {
                min = x;
            }else{
                min = Math.min(st.peek().y, x);
            }
            st.push(new Pair(x, min));
        }

        public void pop(){
            st.pop();
        }

        public int top(){
            return st.peek().x;
        }
        public int getMin(){
            return st.peek().y;
        }
    }

    // TC : O(1)
    // SC : O(2N)



    // solution 2 : 
    class MinStackSol2{
        Stack<Long> st = new Stack<Long>();
        Long mini;

        // initialize your data stucture here 
        public MinStackSol2(){
            mini = Long.MAX_VALUE;
        }

        public void push(int value){
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
                mini = 2* mini -val;
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
public class q8_implementMinStack {
   public static void main(String[] args) {
    MinStackSol2 s = new MinStackSol2();
   
    // Function calls
    s.push(3);
    s.push(5);
    s.getMin();
    s.push(2);
    s.push(1);
    s.getMin();
    s.pop();
    s.getMin();
    s.pop();
    // s.peek();
   }

}