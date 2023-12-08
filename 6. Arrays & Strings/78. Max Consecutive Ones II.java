

//     https://www.lintcode.com/problem/883/


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int j = 0;
        int cz = 0;
        int res = 0;

        while(i < nums.length){
            if(nums[i] == 0){
                cz++;
            }

            while(cz > 1){
                if(nums[j] == 0){
                    cz--;
                }
                j++;
            }

            int len = i - j + 1;
            res = Math.max(res, len);
            i++;
        }

        return res;
    }
}