

//   https://leetcode.com/problems/plus-one/description/

//   https://practice.geeksforgeeks.org/problems/plus-one/1


import java.util.*;
class Solution {
    public int[] plusOne(int[] dig) {
        
        for(int i = dig.length - 1; i >= 0; i--){
            if(dig[i] < 9){
                dig[i]++;
                return dig;
            }

            dig[i] = 0;
        }

        dig = new int[dig.length + 1];
        dig[0] = 1;
        return dig;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXX=======>    GFG     <=======XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int n) {
        
        //  For trilling zeros.
        while (arr.size() > 1 && arr.get(0) == 0) {
            arr.remove(0);
        }
        
        for(int i = n - 1; i >= 0; i--){
            if(arr.get(i) < 9){
                arr.set(i, arr.get(i) + 1);
                return arr;
            }
            
            arr.set(i, 0);
        }
        
        ArrayList<Integer> newArr = new ArrayList<>(n + 1);
        newArr.add(1);
        for(int i = 0; i < n; i++){
            newArr.add(0);
        }
        
        return newArr;
    }
};