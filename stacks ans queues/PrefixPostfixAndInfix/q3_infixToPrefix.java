package PrefixPostfixAndInfix;

import java.util.Stack;

public class q3_infixToPrefix {
   // solution to solve this infix expression  ex : "9-5+3*4/6"
   public static String infixToPrefix(String str){
    int n = str.length();
    // we are using two stacks , one for the values and another for the operators 
    Stack<String> val = new Stack<>();
    Stack<Character> oper = new Stack<>();

    for(int i=0;i<n;i++){
        // fist we will take the character one by one
        char ch = str.charAt(i);
        // ascii value of as character '0'--> 48 and 9-->57
        int ascii = (int) ch;

        // if our ascii value is between 48 and 57 or equal to it then it is a number
        if (ascii>=48 && ascii<=57) {
            // when we have a character and we have to change it into integer
            // example here ch = 5  , then it ascii value = 53 we don't want to push 53 right, so we wil do ascii-48 as we have to push 5 to the val as a string
            String t = " " + ch;
            val.push(t);
        }
        // one change is that if my character is also a '(' then also push it in the stack or if the peek element is '(' , then also push the character
        else if(oper.size()==0 || ch == '(' || oper.peek()=='('){
            // if our operator stack is empty that means we can push directly it it into the operator stack
            oper.push(ch);
        }
        else if (ch == ')') {
            while (oper.peek()!='(') {
                // work
                String v2 = val.pop();
                String v1 = val.pop();
                char operator = oper.pop();
                String t = operator + v1 + v2;
                val.push(t);
            }
            oper.pop();  // this pop for removing the '('  bracket
            
        }
        else{
            if (ch == '+' || ch == '-') {
                // work (write the condition)
                String v2 = val.pop();
                String v1 = val.pop();
                char operator = oper.pop();
                String t = operator + v1 + v2;
                val.push(t);
                oper.pop();

                //push
                oper.push(ch);
            }
             if (ch == '*'  || ch == '/') {
               if (oper.peek() == '*' || oper.peek() == '/') {
                 // work (write the condition)
                String v2 = val.pop();
                String v1 = val.pop();
                char operator = oper.pop();
                String t = operator + v1 + v2;
                val.push(t);
 
                //push
                oper.push(ch); 
               }
               else{
                oper.push(ch);
               }
            }    
        }  
    }
    while ( val.size()>1) {
        String v2 = val.pop();
        String v1 = val.pop();
        char operator = oper.pop();
        String t = operator + v1 + v2;
        val.push(t);
    }

    return  val.pop();
   }

   public static void main(String[] args) {
    String infix = "9-(5+3)*4/6";
    System.out.println("The infix expression is " +  infix);
    String ans = infixToPrefix(infix);
    System.out.println("The prefix expression is " +  ans); 
   }
}


// Time Complexity Analysis:
// Iterating Through the Input String: The code iterates through each character of the input string once.
// Time Complexity: O(n), where n is the length of the input string.
// Operations Inside the Loop:
// All operations inside the loop are stack operations (push, pop, peek), arithmetic operations (+, -, *, /), and comparisons.
// These operations have constant time complexity.
// While Loop at the End: After the main loop, there's another loop that runs until the val stack has only one element left.
// This loop runs a constant number of times (at most n - 1 times where n is the length of the input string).
// Time Complexity: O(n)
// Overall, the time complexity of the code is O(n), where n is the length of the input string.




// Space Complexity Analysis:
// Stacks: Two stacks are used (val and oper) which could potentially store all characters of the input string.
// In the worst case, the size of these stacks can be proportional to the length of the input string.
// Space Complexity: O(n)
// Variables: A few variables (n, ch, ascii, t, v1, v2, operator) are used, but they occupy constant space regardless of the input size.
// Space Complexity: O(1)
// Overall, the space complexity of the code is O(n), where n is the length of the input string, dominated by the space used by the stacks.