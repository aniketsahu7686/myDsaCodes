import java.util.Scanner;

public class q6_bikersCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        int c = 0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                ans += c;
            }else{
                c++;
            }
        }

        System.out.println(ans);
    }
}




// The problem asks you to count the number of crossing bikers given an array of binary digits, where:

// 0 represents a biker running to the north.
// 1 represents a biker running to the south.
// A "crossing" occurs when a biker running north (represented by 0) comes before a biker running south (represented by 1).
// Your task is to count how many such pairs of crossing bikers there are in the given array.


// For example:
// Input: [0, 1, 0, 1, 1]
// Output: 5 (as there are 5 pairs of crossing bikers).
// Explanation: Count all pairs where a 0 comes before a 1 in the array.