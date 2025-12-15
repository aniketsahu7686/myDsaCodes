import java.util.Arrays;
import java.util.Scanner;

public class q13_stringConstruction {
    public static String stringConstruction(int n,int k){
        char[] ans = new char[n];
        // start all index with 'a'
        Arrays.fill(ans, 'a');


        // as we are filling the indexes values wiht 'a'
        int diff = k - n;

        int index = n-1;

        while(diff>0){
            int add = Math.min(diff,25);
            // Convert 'a' to the required character
            ans[index] += add;
            diff -= add;
            index--;
        }
        return new String(ans);
    }

    // TC : O(N)
    // SC : O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        String ans = stringConstruction(n,k);
        System.out.println(ans);
    }
}