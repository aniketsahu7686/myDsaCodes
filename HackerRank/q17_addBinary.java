import java.util.*;

public class q17_addBinary {
    public static String addBinary(String a,String b){
        StringBuilder res = new StringBuilder();
        int len1 = a.length()-1;
        int len2 = b.length()-1;

        int base = 2;
        int carry = 0;

        while (len1>=0 || len2>=0) {
            int h1 = 0,h2 = 0,sum;

            if (len1>=0) {
                h1 = a.charAt(len1--) - '0';
            }
            if (len2>=0) {
                h2 = b.charAt(len2--) - '0';
            }

            sum = h1 + h2 + carry;

            if (sum>=base) {
                carry = 1;
                sum = sum-base;
            }else{
                carry = 0;
            }
            res.append(sum);
        }
        if (carry==1) {
            res.append(carry);
        }

        return res.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));
    }
}


// TC : O(n)
// SC : O(n)