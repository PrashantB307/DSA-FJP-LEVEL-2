

//     https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

//     https://practice.geeksforgeeks.org/problems/search-in-rotated-array-2/1



class Solution {
    public boolean search(int[] nums, int target) {
        
        int lo = 0;
        int hi = nums.length - 1;

        while( lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] < nums[hi]){
                if(target >= nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }else if(nums[mid] > nums[hi]){
                if(target >= nums[lo] && target <= nums[mid]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else {
                hi--;
            }
        }

        return false;
    }
}