package BasicsStackAndQueueToLearn;
public class q1_implementStackUsingArr {
    public static void main(String[] args) {
        Stack ans = new Stack();
        ans.push(7);
        ans.push(8);
        ans.push(9);

        System.out.println("Top of the stack before deleting any element " + ans.top());
        System.out.println("Size of the stack before deleting any element " + ans.size());
        System.out.println("The element deleted is " + ans.pop());
        System.out.println("Size of the stack after deleting an element " + ans.size());
        System.out.println("Top of the stack after deleting an element " + ans.top());
    }
}


class Stack{
    int size = 1000;
    int arr[] = new int[size];
    int top = -1;

    void push(int x){
        top++;
        arr[top] = x;
    }

    int pop(){
        int x = arr[top];
        top--;
        return x;
    }
    int top(){
        int x =arr[top];
        return x;
    }
    int size(){
        return top + 1;
    }
}


// Time Complexity: O(N)
// Space Complexity: O(N)