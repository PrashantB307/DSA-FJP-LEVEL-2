

//     https://practice.geeksforgeeks.org/problems/search-pattern0205/1


import java.util.*;
class Solution
{
    ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int[] lps = getLPS(pat);

        int i = 0;
        int j = 0;
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;

                if(j == pat.length()){
                    res.add(i - j + 1);
                    j = lps[j - 1];
                }
            }else if(j == 0){
                i++;
            }else{
                j = lps[j - 1];
            }
        } 

        return res;
    }

    int[] getLPS(String s){

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

       return lps;
    }
}
