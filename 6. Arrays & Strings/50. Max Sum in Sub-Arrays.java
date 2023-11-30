

//      https://practice.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1


class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        
        long ans = 0;
        
        for(int i = 0; i < N - 1; i++){
            if(arr[i] + arr[i + 1] > ans){
                ans  = arr[i] + arr[i + 1];
            }
        }

        return ans;
    }
}