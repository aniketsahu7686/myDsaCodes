

import java.io.*;
import java.util.*;

public class q10_findMinFactorialNum {

    
    static List<Integer> fact = new ArrayList<Integer>(10);
    static List<Integer> ans = new ArrayList<Integer>();
    
    
    public static int minNum(int N){
        if(N==0){
            return 1;
        }
        else if(N<0){
            return 0;
        }
        for(int i=9;i>=0;i--){
            if(fact.get(i)>N){
                continue;
            }
            ans.add(i);
            int d = minNum(N-fact.get(i));
            
            if(d==1){
                return 1;
            }
            // here remove the last element
            ans.remove(ans.size()-1);
        }
        return 0;
    }
    
    public static List<Integer> printAns(int N){
        fact.add(1);  // foctorial for 0
        fact.add(1);  // foctorial for 1
        for(int i=2;i<=9;i++){
            fact.add(i * fact.get(i-1));
        }
        
        minNum(N);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        int N = sc.nextInt();
        
        List<Integer> ans = printAns(N);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i));
        }
    }
}