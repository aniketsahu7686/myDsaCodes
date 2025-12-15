import java.sql.Time;

public class q19_binaryToDec {
    public static int binaryToDec(int n){
        int base = 1;
        int ans = 0;

        while (n!=0) {
            int rem = n%10;

            ans += rem * base;
            base =base*2;

            n=n/10;
        }
        return ans;
    }

    // Time complexity : O( log n) We can also say time complexity as O(d) where d is number of digits.
    // Auxiliary Space : O(1)
    
    public static void main(String[] args) {
        int n = 1010;
        System.out.println(binaryToDec(n));
    }
}
