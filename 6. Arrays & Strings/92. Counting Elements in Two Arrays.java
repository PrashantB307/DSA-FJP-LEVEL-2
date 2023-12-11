


//     https://practice.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1


import java.util.*;
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       ArrayList<Integer>res = new ArrayList<>();
       Arrays.sort(arr2);
       
       int count=0;
       for(int i = 0; i < m; i++){
           count = search(arr2, arr1[i]);
           res.add(count);
           count = 0;
       }
       
       return res;
    }
    
    public static int search(int[] arr, int n){
        int lo = 0;
        int hi = arr.length - 1;
        int ans = 0;
        while( lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(arr[mid] <= n){
                lo = mid + 1;
                ans = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return ans;
    } 
}