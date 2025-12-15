import java.util.Scanner;

public class q5_complementOfaNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if(x==0){
            System.out.println(1);
            return;
        }
        // this will find the length of  of the binary of the number x
        int length = Integer.toBinaryString(x).length();

        // this will find the mask , (here mask means we know that when we xor 1 with 1 and 0  with 0 it will become 0 and 0 with 1
        // and 1 with 0 it will become 1)
        int mask = ((1 << length) - 1);

        // so when we do xor of num with the mask , we will get the ans
        int ans = x ^ mask;

        System.out.println(ans);



    }
}
