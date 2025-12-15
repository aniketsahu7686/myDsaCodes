public class q10_findTheMissingNumInArray {
    // brute force approach
    public static int findTheMissingNumBf(int[] arr,int N){
        // outer loop that runs from 1 to N
        for(int i=1;i<=N;i++){
            // flag variable to check if an element exists
            int flag = 0;
            for(int j=0;j<N-1;j++){
                if (arr[j]==i) {
                    // when i is present in the array 
                    flag = 1;
                    break;
                }
            }
            // check if the element is missing

            if (flag==0) {
                return i;
            }
        }
        // The following line will never execute ,  It is just to avoid warnings.
        return -1;
    }

    // TC : O(N2), where N = size of the array+1.
    //      Reason: In the worst case i.e. if the missing number is N itself, the outer loop will run for N times, and for every
    //      single number the inner loop will also run for approximately N times. So, the total time complexity will be O(N2).
    // SC : O(1) , as we are not using any extra space. 

    
    // brute force Approach
    public static int findTheMissingNumBetterApp(int[] arr,int N){
        // we will initialize a hash array where we will store the frequency of the elements
        int[] hash = new int[N+1];

        // now for storing the frequencies
        for(int i=0;i<N-1;i++){
            hash[arr[i]]=1; // here we are setting the value of arr as its indexes and as it will be order , with given value of N as 
            // from intially the hash[index] value will become 1 from 0 which is the frequency 
        }

        // now check the frequencies from 1 to N
        for(int i=1;i<=N;i++){
            if (hash[i]==0) {
                return i;
            }
        }

        // The following line will never execute. It is just to avoid warnings.
        return -1;
    }

    // TC : O(N) + O(N) ~ O(2*N),  where N = size of the array+1.
    //      Reason: For storing the frequencies in the hash array, the program takes O(N) time complexity and for checking the 
    //      frequencies in the second step again O(N) is required. So, the total time complexity is O(N) + O(N).
    // SC : O(N), where N = size of the array+1. Here we are using an extra hash array of size N+1.


    // optimal approach 1
    public static int findTheMissingNumopt1(int[] arr,int N){
        int sum1 = (N*(N+1))/2;
        int sum2 = 0;
        for(int i=0;i<N;i++){
            sum2+=arr[i];
        }
        int missingNum = sum1-sum2;
        return missingNum;
    }

    // TC :  O(N), where N = size of array+1 , 
    //       Reason: Here, we need only 1 loop to get the sum of the array elements. The loop runs for approx. N times. So, the 
    //       time complexity is O(N).
    // SC : O(1) as we are not using any extra space.


    // optimal approach 2
    public static int findTheMissingNumOpt2(int[] arr,int N){
        int xor1 = 0, xor2 = 0;
        for(int i=0;i<N-1;i++){
            // xor of the array elements 
            xor2 =  xor2 ^ arr[i];
            // xor upto the [1....N-1]
            xor1 = xor1 ^ (i+1);
        }
        // xor upto the [1....N]
        xor1 = xor1 ^ N;
        // here the missingNumber is 
        int misssingNum = xor1^xor2;
        return misssingNum;
    }

    // TC :  O(N), where N = size of array+1. Reason: Here, we need only 1 loop to calculate the XOR. The loop runs for approx 
    //       N times. So, the time complexity is O(N).
    // SC : O(1) as we are not using any extra space.


    // Note:  Among the optimal approaches, the XOR approach is slightly better than the summation one because the term (N * (N+1))/2 
    //        used in the summation method cannot be stored in an integer if the value of N is big (like 105). In that case, we have to
    //        use some bigger data types. But we will face no issues like this while using the XOR approach.

    
    public static void main(String[] args){
        int N = 5;
        int[] arr = {1,2,3,4};
        // System.out.println(findTheMissingNumBf(arr, N));
        // System.out.println(findTheMissingNumBetterApp(arr, N));
        System.out.println(findTheMissingNumOpt2(arr, N));
    }
}
