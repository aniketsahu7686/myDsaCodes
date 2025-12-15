package com.example.searchingandsorting;

public class question1 {
    int firstOccur(int arr[],int n,int x){
        int s = 0,e = n-1;
        int mid  = s+(e-s)/2;
        int ans = -1;
        while (s<=e){
            if (arr[mid]==x){
                ans = mid;
                e = mid-1;
            }
            else if (x>arr[mid]){ //right me joa
                s = mid+1;
            }
            else if (x<arr[mid]){
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
    int lastOccur(int arr[],int n,int x){
        int s = 0,e = n-1;
        int mid  = s+(e-s)/2;
        int ans = -1;
        while (s<=e){
            if (arr[mid]==x){
                ans = mid;
                e = mid+1;
            }
            else if (x>arr[mid]){ //right me joa
                s = mid+1;
            }
            else if (x<arr[mid]){
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3,5,5};
        question1 ss = new question1();
        System.out.println(ss.firstOccur(arr,8,3));
        System.out.println(ss.lastOccur(arr,8,3));


    }
}

