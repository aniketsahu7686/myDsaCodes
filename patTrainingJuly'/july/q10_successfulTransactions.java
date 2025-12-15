package july;

import java.util.*;
class q10_successfulTransactions
{
  public static int TransactionStatus(int n,int[] arr){
    int change30 = 0, change60 = 0,change120 = 0;
    for(int i=0;i<n;i++){
      if(arr[i]==30){
        // if the customer pays 30 , no change is required
        change30++;
      }
      else if(arr[i]==60){
        if(change30>0){
          change30--;
        }else{
          return 0;
        }
      }
      else if(arr[i]==120){
        if(change30>0 && change60>0){
          change30--;
          change60--;
        }else if(change30>=3){
          change30 -= 3;
        }
        else{
          return 0;
        }
      }
    }
    return 1;
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<arr.length;i++){
      arr[i] = sc.nextInt();
    }
    
    int ans = TransactionStatus(n,arr);
    if(ans==1){
      System.out.println("Transaction successful");
    }
    else{
      System.out.println("Transaction failed");
    }
  }
  }
