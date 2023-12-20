    

//    https://practice.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero1737/1


import java.util.*;
class Solution
{
    public static int closestToZero (int arr[], int n)
    {
        Arrays.sort(arr);
        int lo = 0;
        int hi = n - 1;
        int maxAns = Integer.MAX_VALUE;
        
        while(lo < hi){
            int sum = arr[lo] + arr[hi];
            
            if(Math.abs(sum) < Math.abs(maxAns)){
                maxAns = sum;
            }else if(Math.abs(sum) == Math.abs(maxAns)){
                maxAns = Math.max(maxAns, sum);
            }
            
            if(sum > 0){
                hi--;
            }else{
                lo++;
            }
        }
        
        return maxAns;
    }
}