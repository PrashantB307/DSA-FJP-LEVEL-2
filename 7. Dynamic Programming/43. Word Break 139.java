

//    https://practice.geeksforgeeks.org/problems/word-break1352/1

//    https://leetcode.com/problems/word-break/

//    https://www.codingninjas.com/studio/problems/word-break_1094901


import java.util.*;
class Sol{

    public static int wordBreak(String A, ArrayList<String> B ){

        HashSet<String> set = new HashSet<>();
        for(String word : B){
            set.add(word);
        }

        int[] dp = new int[A.length()];

        for(int i = 0; i < A.length(); i++){
            if(set.contains(A.substring(0, i + 1))){
                dp[i] = 1;
            }else{
                for(int j = 0; j < i; j++){
                    if(dp[j] == 1 && set.contains(A.substring(j + 1, i + 1))){
                        dp[i] = 1;
                    }
                }
            }
        }

        return dp[A.length() - 1]; 
    }
}