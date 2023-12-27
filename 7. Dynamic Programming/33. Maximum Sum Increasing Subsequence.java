

//    https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1


class Solution {
    public int maxSumIS(int nums[], int n) {

        int[] lis = new int[nums.length]; // lis = Longest Incressing Subsequence.
        int omax = Integer.MIN_VALUE; // omax = Overall Max

        for (int i = 0; i < nums.length; i++) {
            Integer max = null;

            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    if (max == null) {
                        max = lis[j];
                    } else if (lis[j] > max) {
                        max = lis[j];
                    }
                }
            }

            if (max == null) {
                lis[i] = nums[i];
            } else {
                lis[i] = max + nums[i];
            }

            omax = Math.max(omax, lis[i]);
        }

        return omax;
    }
}