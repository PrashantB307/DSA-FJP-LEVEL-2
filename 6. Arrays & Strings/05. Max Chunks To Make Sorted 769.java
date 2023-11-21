


//     https://leetcode.com/problems/max-chunks-to-make-sorted/

//     https://practice.geeksforgeeks.org/problems/maximum-number-of-partitions-that-can-be-sorted-individually-to-make-sorted2926/1


class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        if(arr.length == 0){
            return 0;
        }

        int count = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);

            if(max == i){
                count++;
            }
        }

        return count;
    }
}
