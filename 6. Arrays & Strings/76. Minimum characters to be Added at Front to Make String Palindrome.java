

//     https://practice.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/1


class Solution {
    public static int minChar(String str) {
        String s1 = str + "$" + new StringBuilder(str).reverse().toString();
        
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
        int strlen = str.length();
        
       return strlen - ppl;
    }
}