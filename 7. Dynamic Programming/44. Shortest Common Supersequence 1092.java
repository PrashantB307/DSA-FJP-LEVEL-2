


//   https://leetcode.com/problems/shortest-common-supersequence/submissions/1086877909/

//   https://www.codingninjas.com/studio/problems/shortest-supersequence_4244493

//   https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1



class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        
        int m = s.length();
        int n = t.length();

        int[][] lcs = new int[m + 1][n + 1];   // lcs = Lowest Common Subsequence.
        
        for(int i = 0; i <= m; i++){
            lcs[i][0] = 0;
        }

        for(int j = 0; j <= n; j++){
            lcs[0][j] = 0;
        }

        for(int  i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == t.charAt(j -1)){
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                }else{
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        int i = m;
        int j = n;
        
        String ans = "";

        while (i > 0 && j > 0){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                ans += s.charAt(i - 1);
                i--;
                j--;

            }else if(lcs[i - 1][j] > lcs[i][j - 1]){
                ans += s.charAt(i - 1);
                i--;

            }else{
                ans += t.charAt(j - 1);
                j--;
            }
        }

        while (i > 0) {
            ans += s.charAt(i - 1);
            i--;
        }

        while (j > 0){
            ans += t.charAt(j - 1);
            j--;
        }

        String ans2 = new StringBuilder(ans).reverse().toString();

        return ans2;
    }
}



// XXXXXXXXXXXXXXXXXXXXXXXXXX=====>    GFG     <======XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX



class Solution2{
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int[][] lcs = new int[m + 1][n + 1];   // lcs = Lowest Common Subsequence.
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(X.charAt(i) == Y.charAt(j)){
                    lcs[i][j] = 1 + lcs[i + 1][j + 1];
                }else{
                    lcs[i][j] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
                }
            }
        }

        return m + n - lcs[0][0];
    }
}