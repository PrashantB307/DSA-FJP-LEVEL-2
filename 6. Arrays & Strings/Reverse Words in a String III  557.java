  

//      https://leetcode.com/problems/reverse-words-in-a-string-iii/description/


class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();

        for(String word : words){
            res.append(new StringBuilder(word).reverse()).append(" ");
        }

        return res.toString().trim();
    }
}