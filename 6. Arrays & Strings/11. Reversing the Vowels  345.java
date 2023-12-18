

//     https://leetcode.com/problems/reverse-vowels-of-a-string/

//     https://practice.geeksforgeeks.org/problems/reversing-the-vowels5304/1


class Solution {
    public String reverseVowels(String s) {
        
        char[] arr = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            char left = arr[l];
            char right = arr[r];

            if(isVowel(left) && isVowel(right)){
               arr[l] = right;
               arr[r] = left;
               l++;
               r--; 
            }else if(isVowel(left)){
                r--;
            }else if(isVowel(right)){
                l++;
            }else{
                l++;
                r--;
            }
        }

        return new String(arr);
    }

    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }

        return false;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public String reverseVowels(String s) {
        
        String check = "aeiouAEIOU";

        StringBuilder sb = new StringBuilder(s);
        int li = 0;
        int ri = sb.length() - 1;
        
        while(li < ri){
            while(li < ri && check.indexOf(sb.charAt(li)) == -1){
                li++;
            }

            while(li < ri && check.indexOf(sb.charAt(ri)) == -1){
                ri--;
            }

            char temp = sb.charAt(li);
            sb.setCharAt(li, sb.charAt(ri));
            sb.setCharAt(ri, temp);

            li++;
            ri--;
        }

        return sb.toString();
    }
}