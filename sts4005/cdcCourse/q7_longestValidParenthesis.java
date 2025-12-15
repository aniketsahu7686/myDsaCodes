package cdcCourse;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack();
        st.push(-1);
        int max = Integer.MIN_VALUE;
        String s = sc.nextLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                max = Math.max(max, i-st.peek());
            }
        }
        System.out.println(max);
	}
}
