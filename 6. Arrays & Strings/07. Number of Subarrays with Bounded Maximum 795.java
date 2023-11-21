

//      https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

//      https://practice.geeksforgeeks.org/problems/number-of-subarrays-with-maximum-values-in-given-range5949/1


class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int s = -1;
        int e = -1;
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= left && nums[i] <= right){
                e = i;
            }else if(nums[i] > right){
                e = s = i ;
            }else{
                //  Nothimg
            }

            res += (e - s);
        }

        return res;
    }
}
