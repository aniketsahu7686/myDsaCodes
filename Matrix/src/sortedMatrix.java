import java.util.Arrays;

public class sortedMatrix {
    public static int[][] sortTheMatrix(int[][] arr,int N){
        int[] store = new int[N*N];
        int k = 0;

        //store the array
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                store[k++] = arr[i][j];
            }
        }

        Arrays.sort(store);
        k=0;

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                arr[i][j] = store[k++];
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] arr = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};

        System.out.println( sortTheMatrix(arr,4));
    }
}
