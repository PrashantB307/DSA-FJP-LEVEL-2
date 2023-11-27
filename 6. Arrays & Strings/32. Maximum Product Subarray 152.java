

//    https://leetcode.com/problems/maximum-product-subarray/

//    https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1


class Solution {
    public int maxProduct(int[] nums) {
        
        int res =  Integer.MIN_VALUE;
        int prod = 1;
        
        for(int i = 0; i < nums.length; i++){
            prod = prod * nums[i];
            res = Math.max(prod, res);

            if(prod == 0){
                prod = 1;
            }
        }

        prod = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            prod = prod * nums[i];
            res = Math.max(prod, res);

            if(prod == 0){
                prod = 1;
            }
        }

        return res;
    }
}