import java.util.*;


// check the given no is  a perfect no or not
// perfect no is  a number which is equal to sum of its divisors
public class q8_perfectNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int sum = 1;

        for(int i=2;i*i<=x;i++){
            if(x%i==0){
                sum += i;
                if(x/i!=i){
                    sum += x/i;
                }
            }
        }

        if(sum==x){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
