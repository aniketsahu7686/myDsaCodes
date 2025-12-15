public class binarySearchRecursiveApproach {
    public static int binarySearchRecursiveApproach(int[] arr,int start,int end,int x){
        if (end>=1){
            int mid = start + (end-start)/2;

            if (arr[mid]==x){
                return mid;
            }else if (arr[mid]>x){
                return binarySearchRecursiveApproach(arr,start,mid-1,x);
            }else {
                binarySearchRecursiveApproach(arr,mid+1,end,x);
            }

        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
