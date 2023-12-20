

//     https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1

//     https://www.codingninjas.com/studio/problems/reverse-words_696444

//     https://leetcode.com/problems/reverse-words-in-a-string/description/



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        String[] arr = S.split("\\.");
        String res = "";
        
        for(int i = arr.length - 1; i >= 0; i--){
            if(i == 0)
                res += arr[i];
            else 
                res += arr[i] + ".";
        }
        
        return res;
    }
}



//XXXXXXXXXXXXXXXXXXXXX   Leetcode   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        String res = "";
        
        for(int i = arr.length - 1; i > 0; i--){
            res += arr[i] + " ";
        }
        
        return res + arr[0];
    }
}