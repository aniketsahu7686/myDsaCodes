package august;
// Betting game
// You are in betting game with initial amount of Rs. 10. If you win the game, you get the betting amount and if you lose the game you
//  have to give it. The winner will set the bet. If you win the game, you always set half of the previous bet( if the previous bet is 
//  one then set the bet to one instead of half) and if you lose your opponent will set double the previous bet.

// You are given a string with a series of W and L representing wins and losses. Print -1, if you cannot continue the game and if you
//  complete the entire series print the final amount you have and the game begins with a bet of Rs. 1



// constraints:
// String size <20

// Sample Input
// WLWLWLWLWLWLW

// Sample Output :
// 17

import java.util.*;


class q4_bettingGame
{
  public static int bettingGame(String input)
  {
    int n = input.length();
    int money = 10;
    int betAmount = 1;
    for(int i=0;i<n;i++){
      if(input.charAt(i)=='W')
      {
        money +=betAmount;
        betAmount = betAmount/2;
        if(betAmount<1)
        {
          betAmount  = 1;
        }
      }else
      {
        money -= betAmount;
        if(money<0)
        {
          return -1;
        }
        betAmount=betAmount*2;
      }
      
      if(money<betAmount)
      {
        return -1;
      }
    }
    return money;
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    
    int ans = bettingGame(input);
    System.out.println(ans);
  }
}