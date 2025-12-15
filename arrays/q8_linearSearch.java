public class q8_linearSearch {
    public static int linearSearch(int[] arr,int n,int k){
        for(int i=0;i<n;i++){
            arr[i] = k;
            return i;
        }
        return -1;
    }
}
