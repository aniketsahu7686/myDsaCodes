import java.util.HashMap;
import java.util.Scanner;

public class q12_sweetSeventeen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,Integer> hp = new HashMap<>();
        hp.put('a',10);
        hp.put('b',11);
        hp.put('c',12);
        hp.put('d',13);
        hp.put('e',14);
        hp.put('f',15);
        hp.put('g',16);
        hp.put('A',10);
        hp.put('B',11);
        hp.put('C',12);
        hp.put('D',13);
        hp.put('E',14);
        hp.put('F',15);
        hp.put('G',16);

        String input = sc.next();
        int output = sweet17(hp,input,17);
        System.out.println(output);

    }
    public static int sweet17(HashMap<Character,Integer> hp,String input,int base){
        int n = input.length();
        int sum = 0;
        int index = 0;

        for(int i=n-1;i>=0;i--){
            if(hp.containsKey(input.charAt(i))){
                sum += (hp.get(input.charAt(i)) * Math.pow(17, index++));
            }else{
                sum += ((input.charAt(i) - '0') * Math.pow(17, index++));
            }
        }

        return sum;
    }
}



// The question is asking you to convert a four-digit number in base 17 (where the digits can include numbers 0-9 and letters A-G 
// representing values 10-16) into its decimal (base 10) equivalent.

// Here's how the base 17 system works:

// Digits in base 17 are 0-9, followed by A=10, B=11, C=12, ..., G=16.
// You are given a number in this base and asked to convert it to a decimal number.
// Example:
// If the input is 1A3G, which is a base 17 number:

// 1 in base 17 is 1.
// A in base 17 is 10.
// 3 in base 17 is 3.
// G in base 17 is 16.
// To convert 1A3G to decimal (base 10):

// 1A3G17 ​ = 1×17^3+ 10×17^2 +3×17^1 +16×170^0