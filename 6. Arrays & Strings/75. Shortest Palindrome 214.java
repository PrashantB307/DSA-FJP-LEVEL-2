

//     https://leetcode.com/problems/shortest-palindrome/


class Solution {
    public String shortestPalindrome(String s) {
        
        String s1 = s + "$" + new StringBuilder(s).reverse().toString();
        
        int[] lps = new int[s1.length()];
        int i = 1;
        int len = 0;

        while(i < s1.length()){
            if(s1.charAt(i) == s1.charAt(len)){
                lps[i] = len + 1;
                i++;
                len++;
            }else if(len == 0){
                lps[i] = 0;
                i++;
                len = 0;
            }else{
                len = lps[len - 1];
            }
        }

        int ppl = lps[lps.length - 1];

        String right = s.substring(ppl);
        return new StringBuilder(right).reverse().toString() + s;
    }
}