

//   https://leetcode.com/problems/rotate-string/description/

//   https://www.codingninjas.com/studio/problems/check-if-one-string-is-a-rotation-of-another-string_1115683


class Solution {
    public boolean rotateString(String s, String goal) {
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(0);
            String str = s.substring(1) + ch;

            if(str.equals(goal)){
                return true;
            }
        }

        return false;
    }
}