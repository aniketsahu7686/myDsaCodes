package PrefixPostfixAndInfix;

import java.util.Stack;

public class q4_infixToPostfix {
    // solution to solve this infix expression  ex : "9-5+3*4/6"
   public static String infixToPostfix(String str){
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
                String t =  v1 + v2 + operator;
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
                String t =  v1 + v2 + operator;
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
                String t =  v1 + v2 + operator;
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
        String t = v1 + v2 + operator;
        val.push(t);
    }

    return  val.pop();
   }

   public static void main(String[] args) {
    String infix = "9-(5+3)*4/6";
    System.out.println("The infix expression is " +  infix);
    String ans = infixToPostfix(infix);
    System.out.println("The postfix expression is " +  ans); 
   }
}
