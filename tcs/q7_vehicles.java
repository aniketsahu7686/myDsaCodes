import java.util.*;

public class q7_vehicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // we have to find the no of four wheelers (FW) and two Wheelers(TW)
        // no of cars
        int V = sc.nextInt();
        // no of wheels
        int W = sc.nextInt();
        int TW = 0;
        int FW = 0;

        if(V>=W || V<2 || W%2!=0){
            System.out.println("Invalid input");
            return;
        }else{
             TW = ((4*V)-W)/2;
             FW = V - TW;
        }

        if (TW >= 0 && FW >= 0) {
            System.out.println("TW = " + TW + " FW = " + FW);
        } else {
            System.out.println("INVALID INPUT");
        }
    }
}


// Reason for the forumula is :
// Solving the system of equations:
        // TW + FW = V
        // 2 * TW + 4 * FW = W
        
        // Rewriting FW in terms of TW from the first equation:
        // FW = V - TW
        // Substituting in the second equation:
        // 2 * TW + 4 * (V - TW) = W
        // Simplifying:
        // 2 * TW + 4 * V - 4 * TW = W
        // -2 * TW = W - 4 * V
        // TW = (4 * V - W) / 2
        // int TW = (4 * V - W) / 2;
        // int FW = V - TW;
