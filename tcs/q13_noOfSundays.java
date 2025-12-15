import java.util.*;

public class q13_noOfSundays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<String> days = Arrays.asList("sun","mon","tue","wed","thur","fri","sat");
        String day = sc.next().toLowerCase();
        int n = sc.nextInt();
        int noOfSundays = 0;

        int index = days.indexOf(day);

        for(int i=0;i<n;i++){
            int today = (index + i)%7;
            if(days.get(today)=="sun"){
                noOfSundays++;
            }
        }

        System.out.println(noOfSundays);
    }
}