public class q1_binaryToDecimal
{
	public static void main(String[] args) {
		int n = 101101;
		int ans = 0;
		int power = 1;
		
		while(n>0){
		    int x = n%10;
		    n = n/10;
		    int temp = x * power;
		    ans += temp;
		    power = power*2;
		}
		
		System.out.println(ans);
	}
}