package august;
import java.util.*;;
class justOperatingSystem {
    public static void thread1(){
        try {
            for(int i=0;i<9;i++){
                System.out.println("task A : " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void thread2(){
        try {
            for(int i=0;i<9;i++){
                System.out.println("task B : " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
    public static void main(String[] args) { 
        thread2();

    
    }    
}