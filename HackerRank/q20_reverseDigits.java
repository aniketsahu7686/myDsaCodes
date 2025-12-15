import java.util.*;


public class q20_reverseDigits {
    public static String firstDectoBina(int n){
        StringBuilder res = new StringBuilder();

        while (n>0) {
            int x = n%2;
            res.append(x);
            n = n/2;
        }
        return res.toString();
    }

    public static int nextBinToDec(String str){
        int n = Integer.parseInt(str);

        int base = 1;
        int ans = 0;

        while (n!=0) {
            int rem = n%10;
            n = n/2;

            ans += rem * base;
            base = base*2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 43261596;
        String tempAns = firstDectoBina(n);
        int finalAns = nextBinToDec(tempAns);
        System.out.println(finalAns);
    }
}
