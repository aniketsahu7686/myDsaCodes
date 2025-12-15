package ImplementationProblems;

import java.util.*;

public class q2_onlineStackSpan {
    // first learn that how to find the normal stack span where all the values(stocks data) are given beforehanded public static void calculateSpan(int price[] ,int n, int stockSpan[]){
    public static void calculateSpan(int[] price,int n,int[] stockSpan){
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

    // now online stock span means we will be given the value of the stocks dynamically means as, it is named as online means,
    // we will not have the access to the future 

    Stack<Integer> stack ;
    ArrayList<Integer> list;
   
    public q2_onlineStackSpan(){
        stack = new Stack<>();
        list = new ArrayList<>();  // we are using here the arraylist beacuse we will be provided with the dynamic input that means arr cannot be use
    }

     int next(int price){
        // index = stack.peek()
        // list.get(index) = value

        list.add(price);

        while (!stack.isEmpty() && list.get(stack.peek())<=price) {
            stack.pop();
        }

        int previousGreaterIndex = (stack.isEmpty()) ? -1:stack.peek();
        int currentIndex = list.size()-1;
        int ans = currentIndex - previousGreaterIndex;
        stack.push(currentIndex);
        return ans;
    }
}
