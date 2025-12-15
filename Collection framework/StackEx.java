import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        // for adding elements in the stack
        st.push(58);        
        st.push(80);        
        st.push(55);        
        st.push(69);        
        st.push(28);
        
        // for accesing the top element
        st.peek();


        // for removing the top element
        st.pop();
        

    }
}
