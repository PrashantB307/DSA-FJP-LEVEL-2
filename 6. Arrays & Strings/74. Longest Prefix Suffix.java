

//    https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1


class Solution {
    int lps(String s) {
       int[] lps = new int[s.length()];
        
        int len = 0;
        int i = 1;

        while (i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len + 1;
                i++;
                len++;
            }else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            }else{
                len = lps[len - 1];
            }
        }

       return lps[lps.length - 1];
    }
}