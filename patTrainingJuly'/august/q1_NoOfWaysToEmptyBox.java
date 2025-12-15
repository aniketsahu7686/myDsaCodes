package august;

import java.sql.Time;
import java.util.Scanner;

// A box contains a number of balls that can only be removed 1 at a time or 3 at a time. How many ways can the box be emptied?
//  The answer can be very large so return it as modulo of 10^9+7.
// For example, there are n=7 balls initially .They can be removed nine ways, as follows:
// 1.(1,1,1,1,1,1,1)
// 2.(1.1.1.1.3)
// 3.(1,1,1,3,1)
// 4.(1,1,3,1,1)
// 5.(1,3,1,1,1)
// 6.(3,1,1,1,1)
// 7.(1,3,3)
// 8.(3,1,3)
// 9.(3,3,1)



// To solve the problem of determining the number of ways to remove n balls from a box when you can only remove 1 or 3 balls at a time,
// we can use dynamic programming.


// Recurrence Relation: dp[i] = dp[i-1] + dp[i-3]
// This relation tells us that:

// The number of ways to remove i balls (dp[i]) can be calculated by summing up:
// The number of ways to remove i-1 balls (dp[i-1]), followed by removing 1 ball.
// The number of ways to remove i-3 balls (dp[i-3]), followed by removing 3 balls.
// Why This Works
// From i-1 to i:
// If you are at a state with i-1 balls and you remove 1 ball, you will have i balls. Therefore, every way to remove i-1 balls 
// (counted by dp[i-1]) can be extended by removing 1 more ball to get a way to remove i balls.

// From i-3 to i:
// Similarly, if you are at a state with i-3 balls and you remove 3 balls, you will have i balls. Thus, every way to remove i-3 balls
//  (counted by dp[i-3]) can be extended by removing 3 more balls to get a way to remove i balls.

// Base Cases
// Before we can use this recurrence relation, we need to define some base cases to start the process:

// dp[0] = 1: There is exactly one way to remove 0 balls, which is to do nothing.
// dp[1] = 1: There is exactly one way to remove 1 ball.
// dp[2] = 1: There is exactly one way to remove 2 balls (by removing 1 ball twice).
// dp[3] = 2: There are two ways to remove 3 balls (either remove 1 ball three times or remove 3 balls at once).


public class q1_NoOfWaysToEmptyBox {
    public static int noOfWays(int n){
        if (n==0) return 1;
        if (n==1) return 1;
        if (n==2) return 1;
        if (n==3) return 2;

        int[] dp = new int[n+1];
        int MOD = 1000000007;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for(int i=4;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-3])%MOD;
        }

        return dp[n];
    }

    // TC : O(N)
    // SC : O(N)

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
    
            int ans = noOfWays(n);
    
            System.out.println(ans);
    }
}
