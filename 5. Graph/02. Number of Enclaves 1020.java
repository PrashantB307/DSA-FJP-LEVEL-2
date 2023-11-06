


//   https://leetcode.com/problems/number-of-enclaves/

//   https://practice.geeksforgeeks.org/problems/number-of-enclaves/1


class Solution {

    boolean flag = true;;
    int len = 0;

    public int numEnclaves(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == 1){
                    flag = true;
                    len = 0;
                    traversal(visited, grid, i, j);
                    if(flag == true){
                        count += len;
                    }
                }
            }
        }

        return count;
    }

    public void traversal(boolean [][] visited, int[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            flag = false;
            return;
        }else if(grid[i][j] == 0){
            return; 
        }else if(visited[i][j] == true){
            return;
        }
        
        len++;
        visited[i][j] = true;

        traversal(visited, grid, i + 1, j);
        traversal(visited, grid, i - 1, j);
        traversal(visited, grid, i, j - 1);
        traversal(visited, grid, i, j + 1);

    }
}