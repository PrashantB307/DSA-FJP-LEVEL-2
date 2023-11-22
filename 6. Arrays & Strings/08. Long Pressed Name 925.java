


//     https://leetcode.com/problems/long-pressed-name/


class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int i = 0;
        int j = 0;

        while(i < typed.length()){
            if(j < name.length() && typed.charAt(i) == name.charAt(j)){
                i++;
                j++;
            }else if(i > 0 && typed.charAt(i) == typed.charAt(i - 1)){
                i++;
            }else{
                return false;
            }
        }

        return j == name.length();
    }
}