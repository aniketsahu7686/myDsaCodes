package cat2;
import java.util.Arrays;
import java.util.Stack;

public class stockSpan {
    public static void calculateSpan(int price[] ,int n, int stockSpan[]){
        Stack<Integer> st = new Stack<>();
        st.push(0);

        stockSpan[0] = 1;
        for(int i=1;i<n;i++){
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            stockSpan[i] = st.isEmpty() ? (i+1) : (i-st.peek());
            st.push(i);
        }

        System.out.print(Arrays.toString(stockSpan));
    } 

    public static void main(String[] args)
    {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int stockSpan[] = new int[n];


        calculateSpan(price, n, stockSpan);
    }
}
