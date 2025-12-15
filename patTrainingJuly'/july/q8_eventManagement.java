package july;
import java.util.*;

public class q8_eventManagement
{
  public static String eventManagement(String ticketNumber){
    String ans = ticketNumber.replace("EF","");
    ans = ans.replace("G","");
    return ans;
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    String ticketNumber = sc.nextLine();
    String ans = eventManagement(ticketNumber);
    System.out.println(ans);
  }
}