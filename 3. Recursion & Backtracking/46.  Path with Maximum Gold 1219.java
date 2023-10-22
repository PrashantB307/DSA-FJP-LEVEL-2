


//      https://leetcode.com/problems/path-with-maximum-gold/


class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int maxSum = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    int sum = dfs(grid, i, j);
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }

        return maxSum;
    }

    public int dfs(int[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = 0;

        int upsum = dfs(grid, i - 1, j);
        int rightsum = dfs(grid, i, j + 1);
        int downsum = dfs(grid, i + 1, j);
        int leftsum = dfs(grid, i, j - 1);

        grid[i][j] = temp;
        
        int maxSum = Math.max(upsum, Math.max(downsum, Math.max(rightsum, leftsum)));

        return temp + maxSum;
    }
}
