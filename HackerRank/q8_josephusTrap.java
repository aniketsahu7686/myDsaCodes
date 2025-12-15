import java.util.Scanner;

public class q8_josephusTrap {
    public static int josephusTrap(int n,int k){
        if (n==1) {
            return 0;
        }
        int x = josephusTrap(n-1, k);
        int y = (x+k)%n;
        return y;
    }
    public static void main(String[] args){
        int n = 5;
        int k = 2;
        int ans = josephusTrap(n,k) + 1;
        System.out.println(ans);

    }
}


// Time Complexity
// The function josephusTrap is called recursively n times, where n is the number of people in the circle. Each recursive call performs a constant amount of work 
// (a few arithmetic operations and a function call). Therefore, the time complexity can be expressed as:
// T(n)=T(n−1)+O(1)
// Solving this recurrence relation, we get:T(n)=O(n)
// T(n)=O(n)

// Space Complexity
// The space complexity is determined by the maximum depth of the recursion stack. In the worst case, the recursion depth will be n, as the function calls itself with
//  decreasing n until 𝑛 becomes 1. Therefore, the space complexity is:O(n)