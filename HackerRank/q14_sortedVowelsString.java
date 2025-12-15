import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class q14_sortedVowelsString {
    public static int sortedVowStrRecursiveApp(int n,int start){
        if (n==0) {
            return 1;
        }

        int cnt = 0;
        for(int i=start;i<5;i++){
            cnt += sortedVowStrRecursiveApp(n-1,i);
        }
        return cnt;
    }

    public static int ans(int n){
         return sortedVowStrRecursiveApp(n,0);
    }

      // TC : O(N!)
    // SC : O(1)

    // dp approach
// Sure! Let's simplify the explanation even more:

// Understand the Problem
// We want to count the number of strings of a given length made only of the vowels a, e, i, o, u, and these strings should be in alphabetical order.

// Initial Observations
// For strings of length 1, each vowel can only appear once. So we have one string each for 'a', 'e', 'i', 'o', 'u'.
// Example with Strings of Length 2
// If the string starts with 'a', it can be followed by any vowel: (aa, ae, ai, ao, au) = 5 options.
// If the string starts with 'e', it can be followed by 'e', 'i', 'o', 'u': (ee, ei, eo, eu) = 4 options.
// If the string starts with 'i', it can be followed by 'i', 'o', 'u': (ii, io, iu) = 3 options.
// If the string starts with 'o', it can be followed by 'o', 'u': (oo, ou) = 2 options.
// If the string starts with 'u', it can only be followed by 'u': (uu) = 1 option.
// Pattern Recognition
// For longer strings, the count of valid strings starting with each vowel depends on the counts from shorter strings.

// Using Dynamic Programming
// Create a Table (2D Array)

// Let's call it dp. Each cell dp[i][j] will store the number of valid strings of length i using the first j vowels.
// Initialize the Table

// For strings of length 1:
// dp[1][1] = 1 (only 'a')
// dp[1][2] = 2 (strings are 'a' and 'e')
// dp[1][3] = 3 (strings are 'a', 'e', and 'i')
// dp[1][4] = 4 (strings are 'a', 'e', 'i', and 'o')
// dp[1][5] = 5 (strings are 'a', 'e', 'i', 'o', and 'u')

// Filling the Table for Lengths Greater Than 1
// To fill dp[i][j] (number of strings of length i using first j vowels):
// Add dp[i][j-1] (number of strings of length i using first j-1 vowels)
// Add dp[i-1][j] (number of strings of length i-1 using first j vowels)
// This accounts for both extending shorter strings and combining counts of different vowel sets.

// Example Calculation for Length 2
// dp[2][1] = 1 (just 'aa')
// dp[2][2] = dp[2][1] + dp[1][2] = 1 + 2 = 3 (aa, ae, ee)
// dp[2][3] = dp[2][2] + dp[1][3] = 3 + 3 = 6 (aa, ae, ee, ai, ei, ii)
// dp[2][4] = dp[2][3] + dp[1][4] = 6 + 4 = 10
// dp[2][5] = dp[2][4] + dp[1][5] = 10 + 5 = 15

// Final Result
// After filling the table for the desired length N, the value dp[N][5] gives the total count of lexicographically sorted strings
//  of length N using all 5 vowels.

    public static int  sortedVowStrDpApp(int n){
        // here n+1 is for the rows if ex n=3 then we take n+1 that is 4 ,as 0 index is taken as unused
        // here 6 for the vowels(a,e,i,o,u) 
        int[][] dp = new int[n+1][6];


        for(int i=1;i<n+1;i++){
            for(int j=1;j<6;j++){
                if (i==1) {
                    dp[i][j] = dp[i][j-1] + 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n][5];
    }

    // Time Complexity: O(N*5)
    // Auxiliary Space: O(N*5)

    // more optimized dp approach
    public static int sortedVowStrDpOpt(int n){
        ArrayList<Integer> arr = new ArrayList<>();
 
        // first we will fill the array with 1 and as for length 1 the max it can produced with one alphabet is 1 for 'a ,e ,i , o, u'
        for(int i=0;i<5;i++){
            arr.add(1);
        }

        // so for length 1 , already we have assign the values in the arr
        // now we will start index from i=2 (as i=1) already completed
        for(int i=2;i<=n;i++){
            // we are starting form 3 index because 4 index will always have 1 ('u' alphabet)
            for(int j=3;j>=0;j--){
                arr.set(j, arr.get(j)+arr.get(j+1));
            }
        }
        
        int ans = 0;

        for(Integer count : arr){
            ans +=count;
        }

        return ans;
    }

    // Time Complexity: O(5*N)
    // Space Complexity: O(1)

    // we can also use a formula for this 
    public static int findNumberOfStrings(int n){
            return (n+1)*(n+2)*(n+3)*(n+4)/24;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();

        // for recursive
        // int ans = ans(n);

        //for dp 
        // int ans = sortedVowStrDpApp(n);

        // for optimized dp
        int ans = sortedVowStrDpOpt(n);
        System.out.println(ans);
    }
}