

//     https://leetcode.com/problems/monotonic-array/description/


class Solution {
    public boolean isMonotonic(int[] nums) {
       
       boolean incr = false;
       boolean decri = false;

       for(int i = 0; i < nums.length - 1; i++){
           int diff = nums[i + 1] - nums[i];

            if(diff > 0){
               incr = true;
            }else if(diff < 0){
                decri = true;
            }
            if(incr && decri){
                return false;
            }
       } 

       return true;

    }
}