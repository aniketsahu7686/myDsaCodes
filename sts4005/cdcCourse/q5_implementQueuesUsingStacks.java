package cdcCourse;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MyStacks
{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    void insert(int d)
    {
        if(s1.isEmpty())
        {
            s1.push(d);
        }
        else
        {
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
            s1.push(d);
            while(!s2.isEmpty())
            {
                s1.push(s2.pop());
            }
        }
    }
    int delete()
    {
        return s1.isEmpty() ? -1:s1.pop();
    }
}
class Main
{

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc=new Scanner(System.in);
        MyStacks st=new MyStacks();
        ArrayList<Integer> a1=new ArrayList<>();
        int t=sc.nextInt();
        while(t-->0)
        {

            int query=sc.nextInt();
            if(query==1)
            {
                st.insert(sc.nextInt());
            }
            else
            {
                a1.add(st.delete());
            }
        }
        for(int ele:a1)
        {
            System.out.print(ele+" ");
        }
	}
}
