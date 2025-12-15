import java.util.*;

// find the no of palindromes in the range from m to n

public class q10_noOfPalindromes {
    public static boolean ispalindrome(int n){
        String temp = Integer.toString(n);
        int end = temp.length()-1;
        int start = 0;
        while(start<=end){
            if(temp.charAt(start++)!=temp.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=m;i<=n;i++){
            if(ispalindrome(i)){
                list.add(i);
            }
        }

        for(int no:list){
            System.out.print(no + " ");
        }
    }
}