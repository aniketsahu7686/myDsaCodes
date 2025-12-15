public class linearSearch {

    public static int search(int[] arr,  int x){
        int N =arr.length;
        for (int i=0;i<N;i++){
            if (arr[i]==x){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,9,8,7,6,5,4};

        System.out.println(search(arr,3 ));
    }
}
