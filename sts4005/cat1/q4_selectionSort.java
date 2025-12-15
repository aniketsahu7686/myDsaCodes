package cat1;
public class q4_selectionSort {
    public static void selectionSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int smallest = i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[smallest]>arr[j]) {
                    smallest = j;
                }
            }
               // swap
               int temp = arr[i];
               arr[i] = arr[smallest];
               arr[smallest] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,5,8,9,6,3,7};
        selectionSort(arr);
        for (int  var : arr) {
            System.out.print(var + " ");
        }
    }
}
