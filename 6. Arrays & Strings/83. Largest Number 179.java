

//      https://leetcode.com/problems/largest-number/

//      https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1

//      https://www.interviewbit.com/problems/largest-number/



import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        
        String[] sarr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            sarr[i] = nums[i] + "";
        }

        Arrays.sort(sarr, (a, b) -> {
            String case1 = a + b;
            String case2 = b + a;

            return case2.compareTo(case1);
        });

        if(sarr[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String val : sarr){
            sb.append(val);
        }

        return sb.toString();
    }
}