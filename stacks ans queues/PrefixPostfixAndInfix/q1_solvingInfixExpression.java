package PrefixPostfixAndInfix;

import java.util.Stack;

public class q1_solvingInfixExpression {
    // solution to solve this infix expression  ex : "9-5+3*4/6"
   public static int infixExpr(String str){
    int n = str.length();
    // we are using two stacks , one for the values and another for the operators 
    Stack<Integer> val = new Stack<>();
    Stack<Character> oper = new Stack<>();

    for(int i=0;i<n;i++){
        // fist we will take the character one by one
        char ch = str.charAt(i);
        // ascii value of as character '0'--> 48 and 9-->57
        int ascii = (int) ch;

        // if our ascii value is between 48 and 57 or equal to it then it is a number
        if (ascii>=48 && ascii<=57) {
            // when we have a character and we have to change it into integer
            // example here ch = 5  , then it ascii value = 53 we don't want to push 53 right, so we wil do ascii-48 as we have to push 5 to the val
            val.push(ascii-48);
        }
        else if(oper.size()==0){
            // if our operator stack is empty that means we can push directly it it into the operator stack
            oper.push(ch);
        }else{
            if (ch == '+' || ch == '-') {
                // work (write the condition)
                int v2 = val.pop();
                int v1 = val.pop();

                if (oper.peek() == '-' ) val.push(v1-v2);
                if (oper.peek() == '+' ) val.push(v1+v2);
                if (oper.peek() == '*' ) val.push(v1*v2);
                if (oper.peek() == '/' ) val.push(v1/v2);

                oper.pop();

                //push
                oper.push(ch);
            }
             if (ch == '*'  || ch == '/') {
               if (oper.peek() == '*' || oper.peek() == '/') {
                 // work (write the condition)
                 int v2 = val.pop();
                 int v1 = val.pop();
 
                 if (oper.peek() == '*' ) val.push(v1*v2);
                 if (oper.peek() == '/' ) val.push(v1/v2);
 
 
                 oper.pop();
 
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
        int v2 = val.pop();
        int v1 = val.pop();


        if (oper.peek() == '-' ) val.push(v1-v2);
        if (oper.peek() == '+' ) val.push(v1+v2);
        if (oper.peek() == '*' ) val.push(v1*v2);
        if (oper.peek() == '/' ) val.push(v1/v2);
        
        oper.pop();
    }

    return  val.pop();
   }

   public static void main(String[] args) {
    String infix = "9-5+3*4/6";
    int ans = infixExpr(infix);
    System.out.println(ans); 
   }
}


// Time Complexity:
// The time complexity of the code mainly depends on the length of the input infix expression str, denoted by n.
// Iterating through the input expression: The code iterates through each character of the input expression once, performing constant time operations on each character. 
// This contributes O(n) to the time complexity.
// Operations within the loop: Within the loop, operations such as pushing and popping elements from stacks, as well as comparisons, are performed. These operations are
//  constant time operations, and they are done a constant number of times for each character. Therefore, they do not add additional complexity to the overall time
// complexity.
// Thus, the overall time complexity of the code is O(n).


// Space Complexity:
// The space complexity of the code depends on the space required by the stacks and any additional variables used.
// Stacks: The code uses two stacks (val and oper) to store values and operators, respectively. The space required by each stack depends on the number of elements pushed
// onto them during the execution of the code. In the worst case, each stack could contain all the elements of the input expression. Therefore, the space complexity of 
// the stacks is O(n).
// Additional variables: The code uses a few additional variables such as n, ch, ascii, v1, and v2, which require constant space regardless of the size of the input. 
// Therefore, the space complexity contributed by these variables is O(1).
// Thus, the overall space complexity of the code is O(n) due to the stacks.