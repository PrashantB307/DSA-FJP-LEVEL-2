

//   https://leetcode.com/problems/kth-ancestor-of-a-tree-node/


class TreeAncestor {
    
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
       
        dp = new int[16][n];
        for(int bit = 0; bit < dp.length; bit++){
            for(int j = 0; j < dp[0].length; j++){
                if(bit == 0){
                    dp[bit][j] = parent[j];
                } else {
                    int mida = dp[bit - 1][j];
                    dp[bit][j] = mida == -1 ? -1 : dp[bit - 1][mida];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
    
        int res = node;
        
        int bit = 0;
        while((1 << bit) <= k){
            boolean on = ((1 << bit) & k) == 0 ? false : true;
            if (on){
                res = dp[bit][res];
                if(res == -1){
                    return res;
                }
            }

            bit++;
        }
        
        return res;
    }
}
