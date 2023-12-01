

//     https://leetcode.com/problems/search-in-rotated-sorted-array/

//     https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array0959/1

//     https://practice.geeksforgeeks.org/problems/search-in-rotated-array-2/1

//     https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1


class Solution {
    public int search(int[] nums, int target) {
        
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){

            if(nums[lo] == target){
                return lo;
            }
            if(nums[hi] == target){
                return hi;
            }

            lo++;
            hi--;
        }

        return -1;
    }
}