
public class q4_decimalToOctal 
{
	public static void main(String[] args) {
	    int n = 14;
	    StringBuilder s = new StringBuilder();
	    
	    
	    while(n!=0){
	        s.append(n%8);
	        n=n/8;
	    }
	    
	    String ans = s.reverse().toString();
	    System.out.println(ans);
	}
}