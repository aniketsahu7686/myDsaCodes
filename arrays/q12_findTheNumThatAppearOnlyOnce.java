import java.util.HashMap;
import java.util.Map;

public class q12_findTheNumThatAppearOnlyOnce {
    // brute force approach
    public static int findTheNumThatAppeOnly1sBf(int[] arr,int n){
        for(int i=0;i<n;i++){
            int num = arr[i];
            int count = 0;

            for(int j=0 ;j<n;j++){
                if(arr[j]==num){
                    // if duplicates contains count will become more than 1
                    count++;
                }
            }
            if (count==1) {
                return num;
            }
        }
        return -1;
    }

    // TC : O(N2), where N = size of the given array. Reason: For every element, we are performing a linear search to count its 
    // occurrence. The linear search takes O(N) time complexity. And there are N elements in the array. So, the total time complexity 
    // will be O(N2).
    // SC :  O(1) as we are not using any extra space.


    // better approach 1
    public static int  findTheNumThatAppeOnly1sBetterApp1(int[] arr,int n){
        // first we have to find out the maximum element in the array 
        int max = arr[0];
        for(int i=0;i<n;i++){
            max = Math.max(arr[i], max);
        }


        // declare the hash array of the max+1
        // and hash the given array 
        int[] hash = new int[max+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]++;  //means hash[arr[i]]=1
        }

        // find the single element and return the ans 
        for(int i=0;i<n;i++){
            if (hash[arr[i]]==1) {
                return arr[i];
            }
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }

    // Note: While searching for the answer finally, we can either use a loop from 0 to n(i.e. Size of the array) or use a loop 
    //       from 0 to maxElement. So, the time complexity will change accordingly.

    // Now, using array hashing it is difficult to hash the elements of the array if it contains negative numbers or a very large
    // number. So to avoid these problems, we will be using the map data structure to hash the array elements.


    // Better approach 2
    public static int findTheNumThatAppeOnly1sBetterApp2(int[] arr,int n){
        // declare the hashmap and hash the given array
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value+1);
        }

        // find whose value of the keys is 1 , then return the key 
        for(Map.Entry<Integer,Integer> input:map.entrySet()){
            if (input.getValue()==1) {
                return input.getKey();
            }
        }
        
        //This line will never execute , if the array contains a single element.
        return -1;
    }

    // TC :  O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1 (N/2) as we are storing n/2 elements + 1 because the 
    //       one extra element we will store once. N = size of the array.
    //    Reason:  We are inserting N elements in the map data structure and insertion takes logM time(where M = size of the map).
    //             So this results in the first term O(N*logM). The second term is to iterate the map and search the single element. 
    //             In Java, HashMap generally takes O(1) time complexity for insertion and search. In that case, the time complexity 
    //             will be O(N) + O(M).
    // SC :  O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.


    // optimal approach
    public static int findTheNumThatAppeOnly1soptimalApproach(int[] arr,int n){
        int xor = 0;
        for(int i=0;i<n;i++){
            xor = xor^arr[i];
        }
        return xor;
    }

    // TC : O(N), as we traversing the array only once
    // SC : O(1) as we not using extra space 

    public static void main(String[] args){
        int[] arr = {4,1,2,1,2};
        int n = 5;
        // System.out.println(findTheNumThatAppeOnly1sBf(arr, n));
        System.err.println(findTheNumThatAppeOnly1sBetterApp2(arr, n));
    }
}
