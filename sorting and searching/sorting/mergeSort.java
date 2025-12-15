// package com.example.sorting;




// Merge Sort is a divide and conquers algorithm, it divides the given array into equal parts and then merges the 2 sorted parts. 

// There are 2 main functions :
// merge() or divide: This function is used to merge the 2 halves of the array. It assumes that both parts of the array are sorted and merges 
//          both of them.
// mergeSort() or conquer: This function divides the array into 2 parts. low to mid and mid+1 to high where,
//  low = leftmost index of the array
//  high = rightmost index of the array
//  mid = Middle index of the array 
// We recursively split the array, and go from top-down until all sub-arrays size becomes 1.





// We will be creating 2 functions mergeSort() and merge().
// mergeSort(arr[], low, high):
// In order to implement merge sort we need to first divide the given array into two halves. Now, if we carefully observe, we need not 
// divide the array and create a separate array, but we will divide the array’s range into halves every time. For example, the given
//  range of the array is 0 to 4(0-based indexing). Now on the first go, we will divide the range into half like (0+4)/2 = 2. So, the
//  range of the left half will be 0 to 2 and for the right half, the range will be 3 to 4. Similarly, if the given range is low to high,
//  the range for the two halves will be low to mid and mid+1 to high, where mid = (low+high)/2. This process will continue until the
//  range size becomes.
// So, in mergeSort(), we will divide the array around the middle index(rather than creating a separate array) by making the recursive
//  call :
// 1. mergeSort(arr,low,mid)   [Left half of the array]
// 2. mergeSort(arr,mid+1,high)  [Right half of the array]
// where low = leftmost index of the array, high = rightmost index of the array, and mid = middle index of the array.
// Now, in order to complete the recursive function, we need to write the base case as well. We know from step 2.1, that our recursion
//  ends when the array has only 1 element left. So, the leftmost index, low, and the rightmost index high become the same as they are
//  pointing to a single element.
// Base Case: if(low >= high) return;




class mergeSort {
    public static void divide(int arr[] ,int start,int end){
 
        if (start>=end){
            return;
        }
//        it is different from  (start+end)/2  because it takes a lot of time complexity  and if start and end both will be big number then there addition  will be
//        greater than int which is long number
        int mid  = start + (end-start)/2;
        divide(arr,start,mid); // left half
        divide(arr,mid+1,end); // right half
        conquer(arr,start,mid,end);  // merging two sorted halves
    }

    public static void conquer(int arr[],int start,int mid,int end){
        int[] merger = new int[end-start+1];

        // starting index of the left half of the array
        int indx1 = start;
        // starting index of right half  of the array
        int indx2 = mid+1;
        int x = 0;

        // storing elements int the temporary array in a sorted manner
        while (indx1<=mid && indx2<=end ){
            if (arr[indx1]<=arr[indx2]){
                merger[x++] = arr[indx1++];
            }else {
                merger[x++] = arr[indx2++];
            }
        }

        // if elements in the left half are still left
        while (indx1<=mid){
            merger[x++] = arr[indx1++];
        }

        // if elements in the right half are still right
        while (indx2<=end){
            merger[x++] = arr[indx2++];
        }


        // tranferring all the elements from temporary to arr
        for (int i=0,j=start; i<merger.length; i++ ,j++){
            arr[j] = merger[i] ;
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        int n = arr.length;

        divide(arr,0,n-1);

        for (int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
