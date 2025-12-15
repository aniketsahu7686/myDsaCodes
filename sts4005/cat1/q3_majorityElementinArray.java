package cat1;

// import java.util.*; 

public class q3_majorityElementinArray {
     //optimal approach  (Moore's voting algorithm)

    // just read (main in notes)
    // If the array contains a majority element, its occurrence must be greater than the floor(N/2). Now, we can say that the count of
    //  minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we 
    //  try to keep track of the count of elements and the element itself for which we are tracking the count. 
    //  After traversing the whole array, we will check the element stored in the variable. If the question states that the array must 
    //  contain a majority element, the stored element will be that one but if the question does not state so, then we need to check if
    //  the stored element is the majority element or not. If not, then the array does not contain any majority element.

    public static int majorityElementopt(int[] arr,int n){
        int cnt = 0;
        int element = 0;
 
        // applying the algorithm
        for(int i=0;i<n;i++){
            if (cnt==0) {
                cnt = 1;
                element = arr[i];
            }else if (element==arr[i]) {
                cnt++;
            }else{
                cnt--;
            }
        }

        // checking if the stored element is the majority element 
        int anothercnt = 0;
        for(int i=0;i<n;i++){
            if (arr[i]==element) {
                anothercnt++;
            }
        }

        if (anothercnt>(n/2)) {
            return element;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {3,3,4,2,4,4,2,4,4};
        int ans = majorityElementopt(arr, 8);
        System.out.println(ans);
    }
}



// tc:O(n) , sc : O(1)