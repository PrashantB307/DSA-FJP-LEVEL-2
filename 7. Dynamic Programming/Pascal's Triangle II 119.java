//    L-119. Pascal's Triangle II


//     https://leetcode.com/problems/pascals-triangle-ii/


import java.util.*;
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long prev = 1;

        for(int i = 1; i <= rowIndex; i++){
            long nextVal = prev * (rowIndex - i + 1) / i;
            res.add((int)nextVal);
            prev = nextVal;
        }

        return res;
    }
}