public class q5_octalToDecimal
{
	public static void main(String[] args) {
	  int octal = 16;
	  int ans = 0;
	  int i = 0;
	  
	  while(octal!=0){
	      int rem = octal%10;
	      ans += rem * Math.pow(8,i);
	      octal = octal/10;
	      i++;
	  }
	  
	  System.out.println(ans);
	}
}