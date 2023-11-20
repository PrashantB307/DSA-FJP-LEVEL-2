

//     https://leetcode.com/problems/container-with-most-water/

//     https://practice.geeksforgeeks.org/problems/container-with-most-water0535/1


class Solution {
    public int maxArea(int[] height) {
        
        int res = 0;

        int l = 0;
        int r = height.length - 1;

        while(l < r){
            int gap = r - l;
            int area = Math.min(l, r) * gap;

            res = Math.max(res, area);

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }

        return res;
    }
}