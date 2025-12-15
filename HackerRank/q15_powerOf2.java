public class q15_powerOf2 {

    // 1st appraoch
    // so we will try to divide the n by 2 upto we get the n as 1,and everytime the remainder should be 0 otherwise real (n) is not a power of 2
    public static boolean powerOf2App1(int n){
        if (n==0) {
            return false;
        }
        while (n!=1) {
            if (n%2!=0) {
                return false;
            }
            n = n/2;
        }
        return true;
    }

    // TC : O(logn)
    // SC : O(1)

    // 2nd appraoch
    // To check if a number is a power of 2, you can use its binary form. A power of 2 has only one '1' bit (like 2 is 10, 4 is 100).
    
    // Subtracting 1 from a power of 2 flips all bits after the '1' bit and turns the '1' bit to '0' (like 4-1=011).

    // If you do a bitwise AND between a power of 2 number and that number minus 1, the result is 0 (like 4 & 3 = 000).

    // To check if a number n is a power of 2, use n & (n - 1) == 0. This will be true only if n is a power of 2.

    // Make sure n is not zero because zero is not a power of 2.

    public static boolean powerOf2App2(int n){
        return n>0 && (n & (n-1)) == 0;
    }

    //TC : O(1)
    //SC : O(1)

    public static void main(String[] args) {
        int n = 35;
        // System.out.println(powerOf2App1(n));
        System.out.println(powerOf2App2(n));
    } 
}