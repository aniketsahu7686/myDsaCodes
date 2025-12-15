public  class interpolationSearch {
    
    public static int interpolatSear(int[] arr ,int low,int high,int target){
        int pos;
        if (low<=high && target>=arr[low] && target<=arr[high]) {
            pos = low + (((target-arr[low])/(arr[high]-arr[low])) * (high-low));   //here low and high are indexes 



            if (arr[pos]==target) {
                return pos;
            }

            if (arr[pos]<target) {
                return interpolatSear(arr,pos+1,high,target);
            }else{
                 return interpolatSear(arr,low,pos-1,target);
            }
        }    
            return -1;
    }
    public static void main(String[] args)
    {
 
        // Array of items on which search will
        // be conducted.
        int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21,
                      22, 23, 24, 33, 35, 42, 47 };
 
        int n = arr.length;
 
        // Element to be searched
        int target = 18;
        int index = interpolatSear(arr, 0, n - 1,target );
 
        // If element was found
        if (index != -1)
            System.out.println("Element found at index "
                               + index);
        else
            System.out.println("Element not found.");
    }
}