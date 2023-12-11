

//    https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1

//    https://leetcode.com/problems/subarray-product-less-than-k/description/



class Solution {
    
    public long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int i = 0, j = 0; 
        long ans = 0;
        long pro = 1;

        while(i < n) {
            pro *= a[i];

            while(j <= i && pro >= k) {
                pro /= a[j];
                j++;
            }
            
            ans += (i - j + 1);
            i++;
        } 
        
        return ans;
        
    }
}