package PrefixPostfixAndInfix;

import java.util.Stack;

public class q5_evalutaionOfPostfixExpression {
    public static int evalutionOfPostfix(String str){
        Stack<Integer> val = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii>=48 && ascii<=57) {
                val.push(ascii-48);
            }else{
                int v2 = val.pop();
                int v1 = val.pop();
                if (ch == '+') {
                    val.push(v1 + v2);
                }
                if (ch == '-') {
                    val.push(v1 - v2);
                }
                if (ch == '*') {
                    val.push(v1 * v2);
                }
                if (ch == '/') {
                    val.push(v1 /  v2);
                }
            }
        }
        return val.peek();
    }
    public static void main(String[] args) {
        String str = "953+4*6/-";
        int ans = evalutionOfPostfix(str);
        System.out.println(ans);
    }
}
