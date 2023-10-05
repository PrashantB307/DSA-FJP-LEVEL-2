

//    https://leetcode.com/problems/xor-queries-of-a-subarray/


class Solution2 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int qs = queries.length;
        int[] xor = new int[n];
        xor[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            xor[i] = xor[i - 1] ^ arr[i];
        }

        int[] ans = new int[qs];

        for(int i = 0; i < qs; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0){
                ans[i] = xor[r];
            }else{
                ans[i] = xor[r] ^ xor[l - 1];
            }
        }

        return ans;
        
    }
}
