


//     https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1

//     https://leetcode.com/problems/palindrome-partitioning/


import java.util.ArrayList;

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String str) {
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        helper(str, ans, res);

       return ans;
    }

    static void helper(String str, ArrayList<ArrayList<String>> ans, ArrayList<String> res){
        
        if(str.length() == 0){
            ans.add(new ArrayList<>(res));
            return ;
        }
        
        for(int i = 0; i < str.length(); i++){
            String prefix = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            
            if(isPalindrom(prefix)){
                res.add(prefix);
                helper(ros, ans, res);
                res.remove(res.size() - 1);
            }
        }
    }

    static boolean isPalindrom(String str){
        int l = 0;
        int r = str.length() - 1;

        while(l < r){
            char left = str.charAt(l);
            char right = str.charAt(r);
            if(left != right){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
