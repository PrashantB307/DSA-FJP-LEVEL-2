

//      https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

//      https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1


import java.util.*;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1];

        while( lo < hi){
            int mid = lo + (hi - lo) / 2;

            int count = 0;
            int j = matrix[0].length - 1;
            
            for(int i = 0; i < matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }

                count += (j + 1);
            }

            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }

        return lo;
    }
}
























// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  Using  PriorityQueue    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX



class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                pq.add(matrix[i][j]);
            }
        }

        for(int i = 0; i < k - 1; i++){
            pq.remove();
        }

        return pq.peek();
    }
}