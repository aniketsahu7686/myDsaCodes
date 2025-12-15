package BasicsStackAndQueueToLearn;
import java.sql.Time;
import java.util.Stack;


public class q7_checkForBalancedParenthesis {
    // solving the problem using the stack
    public static boolean isValidUsingStack(String str){
        Stack<Character> st = new Stack<Character>();

        for(char it:str.toCharArray()){
            if (it=='(' || it == '[' || it == '{') {
                st.push(it);
            }else{
                if (st.empty()) {
                    return false;
                }
                char ch = st.pop();
                if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{')) {
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return str.isEmpty();
    }

    // Time Complexity: O(N)
    // Space Complexity: O(N)


    // Can we do it with a constant space ?
    
    public static boolean isValidInConstantSpace(String str){
        int i = -1;
        char[] stack = new char[str.length()];
        for(char ch:str.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++i] = ch;
            }else{
                if (i>=0 && ((stack[i] == '(' && ch == ')') || (stack[i] == '[' && ch == ']') || (stack[i] == '{' &&  ch == '}'))) {
                    i--;
                }else{
                    return false;
                }
            }
        }
        return i == -1;
    }


    

    public static void main(String[] args) {
        String str = "()[{}()]";
        // if (isValidUsingStack(str)==true) {
        //     System.out.println("True");
        // }else{
        //     System.out.println("False");
        // }
        if (isValidInConstantSpace(str)) {
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
