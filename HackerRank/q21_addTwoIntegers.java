// Given two integers a and b, return the sum of the two integers without using the operators + and -.

public class q21_addTwoIntegers {
    public static int addTwoIntgers(int x,int y){

        
        while(y!=0){
            // carry now contains common set bits of x and y
            int carry = x&y;

             // Sum of bits of x and  y where at least one  of the bits is not set
             x = x^y;

            // Carry is shifted by one so that adding it to x gives the required sum
             y = carry<<1;
        }

        return x;
    }
    public static void main(String[] args) {
        int a = -12;
        int b = -8;
        int ans = addTwoIntgers(a, b);
        System.out.println(ans);
    }
}