import java.util.*;
// given an array of no , we have to jump to lastIndex ,if yes return true ,else false
// jump will be on the condition that it will jump equal to the index no 


public class q9_jumpToLastIndex {
    public static boolean jumpToLastIndex(ArrayList<Integer> list){
        int n = list.size() - 1;
        int temp = 0;
        while(temp<n){
            temp += list.get(temp);

            if(temp==0){
                return false;
            }

            if (temp==n) {
                return true;
            }
        }

        return false;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while(sc.hasNext()){
            int a = sc.nextInt();
            if(a==-1){
                break;
            }
            list.add(a);

        }

        boolean ans = jumpToLastIndex(list);
        System.out.println(ans);
    }
}