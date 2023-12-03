

//      https://www.interviewbit.com/problems/allocate-books/


import java.util.*;
class Solution {
    public int books(ArrayList<Integer> A, int B) {
        
        if(A.size() < B){
            return  -1;
        }
        
        int lo = Integer.MIN_VALUE;
        int hi = 0;

        for(int val : A){
            hi += val;
            lo = Math.max(lo, val); 
        }

        while(lo < hi){
            int allot = (lo + hi) / 2;
           

            int count = 1;
            int sum = 0;

            for(int val : A){
                if(sum + val <= allot){
                    sum += val;
                }else{
                    count++;
                    sum = val;
                }
            }

            if(count > B){
                lo = allot + 1;
            }else{
                hi = allot;
            }
        }

        return lo;
    }
}
