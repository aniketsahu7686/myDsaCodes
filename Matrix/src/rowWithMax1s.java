
    public class rowWithMax1s {
        public static int rowwithmax1s(int[][] arr,int n,int m){
            int col = m-1;
            int row = -1;

//        traversing row by row
            for (int i=0;i<n;i++){
//            last column to first
                for (int j=col;j>=0;j--){
                    if (arr[i][j]==1){
                        row = i;
//                    we will not see that column again as topper 1 will not ask anybody if ur a topper because 1 itself is a topper
                        col--;
                    }
                    else {
                        break;
                    }
                }
            }
            return row;
        }
        public static void main(String[] args) {
            int[][] arr = {{0, 1, 1, 1},
                    {0, 0, 1, 1},
                    {1, 1, 1, 1},
                    {0, 0, 0, 0}};
            System.out.println(rowwithmax1s(arr,4,4));
        }
    }

