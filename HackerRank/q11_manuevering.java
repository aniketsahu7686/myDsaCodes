import java.sql.Time;
import java.util.Scanner;

public class q11_manuevering {
    public static int noOfPaths(int m,int n){
        // base case
        if (n==1 || m==1) {
            return 1;
        }

        return noOfPaths(m-1, n) + noOfPaths(m, n-1);
    }

    // Time Complexity: O(2N)
    // Auxiliary Space: O(N + M)



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int ans = noOfPaths(m,n);
        System.out.println(ans);
    }
}