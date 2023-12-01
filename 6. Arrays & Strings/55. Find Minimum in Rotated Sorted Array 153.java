

//      https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

//      https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1


class Solution {
    public int findMin(int[] nums) {
        
        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi){
            int mid = lo + hi / 2;

            if(nums[hi] > nums[mid]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return nums[lo];
    }
}