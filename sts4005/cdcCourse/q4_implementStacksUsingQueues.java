package cdcCourse;


/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MyQueues
{
    Queue q1=new LinkedList();
    Queue q2=new LinkedList();
    void enqueue(int d)
    {
        if(q1.isEmpty())
        {
            q1.add(d);
        }
        else
        {
            while(!q1.isEmpty())
            {
                q2.add(q1.poll());
            }
            q1.add(d);
            while(!q2.isEmpty())
            {
                q1.add(q2.poll());
            }
        }
    }
    int dequeue()
    {
        if(q1.isEmpty())
        {
            return -1;
        }
        return (int)q1.poll();
    }
}
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        MyQueues q=new MyQueues();
        ArrayList<Integer> a1=new ArrayList();
        while(t>0)
        {
            int query=(sc.nextInt());
            if(query==1)
            {
                q.enqueue(sc.nextInt());
            }
            else if(query==2)
            {
                a1.add(q.dequeue());

            }
            t--;
        }
        for(int ele:a1)
        {
            System.out.println(ele);
        }
	}
}