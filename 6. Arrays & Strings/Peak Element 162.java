

//    https://leetcode.com/problems/find-peak-element/description/

//    https://practice.geeksforgeeks.org/problems/peak-element/1

//    https://www.codingninjas.com/studio/problems/find-peak-element_1081482



class Solution {
    public int findPeakElement(int[] nums) {
        int ans = 0;
        int max = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                ans = i;
            }
        }
        
        return ans;
    }
}