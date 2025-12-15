import java.util.Scanner;

public class q6_chocolateFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int count = 0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[count++] = arr[i];
            }
        }

        for(int i=count;i<n;i++){
            arr[i] = 0; 
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}




// This problem is about handling a list of packets where some packets are empty. The empty packets are represented by the number 0.

// You are given an array (list) of numbers, where:

// Non-zero numbers represent filled chocolate packets.
// 0 represents an empty packet.
// The task is to move all the empty packets (0s) to the end of the array while keeping the order of the non-empty packets the same.

// For example:
// If the input is [4, 5, 0, 1, 9, 0, 5, 0], the result should be [4, 5, 1, 9, 5, 0, 0, 0].
// The 0s (empty packets) have been moved to the end, and the other numbers stay in their original order.
// Your goal is to rearrange the array so that all empty packets are pushed to the end while maintaining the order of the rest.

