

//     https://leetcode.com/problems/majority-element-ii/


import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int c1 = 0;
        int can1 = 0;
        int c2 = 0;
        int can2 = 0;

        for(int val : nums){
            if(val == can1){
                c1++;
            }else if(val == can2){
                c2++;
            }else if(c1 == 0){
                c1 = 1;
                can1 = val;
            }else if(c2 == 0){
                c2 = 1;
                can2 = val;
            }else{
                c1--;
                c2--;
            }
        } 

        c1 = 0;
        c2 = 0;

        for(int val : nums){
            if(val == can1){
                c1++;
            }else if(val == can2){
                c2++;
            }
        }

        List<Integer> res = new ArrayList<>();

        if(c1 > nums.length / 3){
            res.add(can1);
        }

        if(c2 > nums.length / 3){
            res.add(can2);
        }

        return res;
    }
}
