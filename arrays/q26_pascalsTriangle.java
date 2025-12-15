import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class q26_pascalsTriangle {
    // variation 1 :  Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

    // well this is the optimal approach
    public static long  nCrVar1(int n ,int r){
        long res = 1;
         
        // calculating nCr:
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        return res;
    }
    public static int pascalTriangleVar1(int r,int c){
        int element = (int) nCrVar1(r-1, c-1);
        return element;
    }

    // Time Complexity: O(c), where c = given column number. Reason: We are running a loop for r times, where r is c-1.
    // Space Complexity: O(1) as we are not using any extra space.



    // variation 2 : Given the row number n. Print the n-th row of Pascal’s triangle.

    // brute force approach
    public static long nCrVar2(int n,int r){
        long res = 1;
         
        // calculating nCr:
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        return res;
    }
    public static void pascalTriangleVar2Bf(int n){
        // for printing the entire row n
        for(int c=1;c<=n;c++){
            System.out.print(nCrVar2(n-1,c-1)  + " ");
        }
        System.out.println();
    }

    // Time Complexity: O(n*r), where n is the given row number, and r is the column index which can vary from 0 to n-1. 
    //                  Reason: We are calculating the element for each column. Now, there are total n columns, and for each column, the calculation of the element 
    //                  takes O(r) time where r is the column index.

    // Space Complexity: O(1) as we are not using any extra space.

    // optimal approach
    public static void pascalTriangleVar2Opt(int n){
        long ans = 1;
        // printing the first element 
        System.out.println(ans +  " ");

        // printing the rest of the part
        for(int i=0;i<n;i++){
            ans = ans*(n-i);
            ans = ans/i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    // Time Complexity: O(N) where N = given row number. Here we are using only a single loop.
    // Space Complexity: O(1) as we not using any extra space.


    // variation 3 : Given the number of rows n. Print the first n rows of Pascal’s triangle.

    // brute force approach
    public static int nCrVar3Bf(int n,int r){
        long res = 1;

        // calculating nCr
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res / (i+1);
        }

        return (int) res;
    }

    public static List<List<Integer>> pascalTriangleVar3bf(int n){
        List<List<Integer>> ans = new ArrayList<>();

        // store the entire pascal's triangle
        for(int row=1;row<=n;row++){
            // temporary list
            List<Integer> tempList = new ArrayList<>();
            for(int col=1;col<=row;col++){
                tempList.add(nCrVar3Bf(row-1, col-1));
            }
            ans.add(tempList);
        }
        return ans;
    }


    // Time Complexity:    O(n*n*r) ~ O(n3), where n = number of rows, and r = column index.
    //                     Reason: The row loop will run for approximately n times. And generating a row using the naive approach of variation 2 takes O(n*r) time
    //                      complexity.
    // Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can be still considered as O(1).


    //optimal approach
    public static List<Integer> generateRowVar3Opt(int row){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        // inseting the first element
        ansRow.add(1);


        // calculate the rest of the elements
        for(int col=1;col<row;col++){
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangleVar3Opt(int n){
        List<List<Integer>> ans = new ArrayList<>();

        // store the entire pascal's triangle
        for(int row = 1;row <= n;row++){
            ans.add(generateRowVar3Opt(row));
        }
        return ans;
    }


    // Time Complexity: O(n2), where n = number of rows(given).
    //                  Reason: We are generating a row for each single row. The number of rows is n. And generating an entire row takes O(n) time complexity.
                     
    // Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can still be considered as O(1).
    

    public static void main(String[] args) {
        //for variation 1 :
        // int r = 5;
        // int c = 3;
        // int element = pascalTriangleVar1(r, c);
        // System.out.println(element);


        // for variation 2  :
        //  brute force approach
    //     int n = 5;
    //    pascalTriangleVar2Bf(n);

       // optimal approach
    //    int n = 5;
    //    pascalTriangleVar2Opt(n);


    // for variation 3 :
    // brute force approach
    // int n = 5;
    // List<List<Integer>> ans = pascalTriangleVar3bf(n);
    // for(List<Integer> it : ans){
    //     for(int elem:it){
    //         System.out.print(elem + " ");
    //     }
    //     System.out.println();
    // }

    // optimal approach
    int n = 5;
    List<List<Integer>> ans = pascalTriangleVar3Opt(n);
    for(List<Integer> it : ans){
        for(int elem:it){
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    }
}
