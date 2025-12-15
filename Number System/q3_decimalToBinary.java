
public class q3_decimalToBinary 
{
	public static void main(String[] args) {
	    int decimal = 14;
	    int i = 0;
		int ans = 0;
		while (decimal!=0) {
			int rem = decimal%2;
			ans += rem * Math.pow(10, i);
			decimal = decimal/2;
			i++;
		}

		System.out.println(ans);
	}
}
