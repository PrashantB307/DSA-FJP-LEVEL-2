

//   https://leetcode.com/problems/number-of-islands/

//   https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1


class Solution {
    public int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    count++;
                    traversal(visited, grid, i, j);
                }
            }
        }

        return count;
    }

    public void traversal(boolean [][] visited, char[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }else if(grid[i][j] == '0'){
            return; 
        }else if(visited[i][j] == true){
            return;
        }

        visited[i][j] = true;

        traversal(visited, grid, i - 1, j);
        traversal(visited, grid, i + 1, j);
        traversal(visited, grid, i, j - 1);
        traversal(visited, grid, i, j + 1);

        // If Diagonally search are allowed (GFG)==> 

        // traversal(visited, grid, i + 1, j + 1);
        // traversal(visited, grid, i - 1, j - 1);
        // traversal(visited, grid, i - 1, j + 1);
        // traversal(visited, grid, i + 1, j - 1);
    }
}
