import java.util.Arrays;
import java.sql.Time;
import java.util.*;

public class q18_DecToBinary {

    // approach 1
    public static String decToBinaryBf(int n){
        StringBuilder res = new StringBuilder();

        while (n>0) {
            int x = n%2;
            res.append(x);
            n = n/2;
        } 
       return  res.reverse().toString();
    }

    // Time Complexity: O(log n) ,This is dominated by the while loop and the subsequent reverse operation.
    // Space Complexity: O(log n) ,This is due to the space required by the StringBuilder object.

    // approach 2
    public static void decToBinaryOpt(int n){

            // Size of an integer is assumed to be 32 bits
            for(int i=31;i>=0;i--){
                int k = n>>i;
                if ((k&1)==1) {
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
    }
    // SC : O(1)
    // TC : O(1)


    public static void main(String[] args) {
        int n = 2;
        System.out.println(decToBinaryBf(n));
    }
}