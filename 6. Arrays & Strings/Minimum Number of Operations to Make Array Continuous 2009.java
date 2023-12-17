

//    https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/description/?envType=daily-question&envId=2023-10-10


import java.util.*;
class Solution {
    public int minOperations(int[] nums) {
    
        int n = nums.length;
        int ans = n;
        Arrays.sort(nums);
        int m = 1;
        int j = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] != nums[i - 1]){
                nums[m] = nums[i];
                m++;
            }
        }

        for(int i = 0; i < m; i++){
            while(j < m && nums[j] < nums[i] + n){
                j++;
            }

            ans = Math.min(ans, n - j + i);
        }

        return ans;
    }
}