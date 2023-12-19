  

//     https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1


import java.util.*;
class Solution {
    boolean checkTriplet(int[] arr, int n) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int val : arr){
            set.add(val * val);
        }
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int val  = arr[i] * arr[i] + arr[j] * arr[j];
                if(set.contains(val)){
                    return true;
                }
            }
        }
        
        return false;
    }
}


