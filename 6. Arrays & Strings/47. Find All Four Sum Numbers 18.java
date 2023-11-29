

//     https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1

//     https://leetcode.com/problems/4sum/description/


import java.util.*;
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        
        Arrays.sort(arr);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        
        int n = arr.length;
        
        for(int i = 0; i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++){
                
                int l = j + 1;
                int r = n - 1;
                
                while(l < r){
                    int sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if(sum == k){
                        List<Integer> li = Arrays.asList(arr[i], arr[j], arr[l], arr[r]);
                        ArrayList<Integer> list = new ArrayList<>(li);
            
                        if(!set.contains(list)){
                            set.add(list);
                            res.add(list);
                        }
                        
                        l++;
                        r--;
                    }else if(sum < k){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        
        return res;
    }
}