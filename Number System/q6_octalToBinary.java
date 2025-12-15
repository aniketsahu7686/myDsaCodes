public class q6_octalToBinary {
    public static int octalToDecimal(int octal){
        int ans = 0;
        int i = 0;
        
        while(octal!=0){
            int rem = octal%10;
            ans += (rem * Math.pow(8,i));
            octal = octal/10;
            i++;
        }

        return ans;
    }
    public static int decimalToBinary(int decimal){
	    int i = 0;
		int ans = 0;
		while (decimal!=0) {
			int rem = decimal%2;
			ans +=  ( rem * Math.pow(10, i) );
			decimal = decimal/2;
			i++;
		}
        return ans;
    }
    public static void main(String[] args) {
        int n = 345;

        int decimal = octalToDecimal(n);
        int binary = decimalToBinary(decimal);
        System.out.println(binary);;
    }
}
