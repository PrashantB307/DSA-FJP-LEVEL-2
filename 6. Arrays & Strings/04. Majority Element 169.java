

//      https://leetcode.com/problems/majority-element/

//      https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1



class Solution {
    public int majorityElement(int[] nums) {
        
        int me = nums[0];     // me = Majority Element
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == me){
                c++;
            }else{
                c--;
                if(c == 0){
                    me = nums[i + 1];
                }
            }
        }

        return me;
    }
}