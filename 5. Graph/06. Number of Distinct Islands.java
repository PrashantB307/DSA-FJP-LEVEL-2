

//    https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1


import java.util.*;
class Solution {

    StringBuilder str = new StringBuilder();

    int countDistinctIslands(int[][] grid) {
        
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        HashSet<String> unique = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == 1){
                    str = new StringBuilder();
                    traverse(grid, visited, i, j);
                    unique.add(str.toString());
                }
            }
        }

        return unique.size();
    }

    void traverse(int[][] grid, boolean [][]visited, int i, int j){

        visited[i][j] = true;

        if(i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == false){
            str.append("N");
            traverse(grid, visited, i - 1, j);
        }

        if(j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == false){
            str.append("W");
            traverse(grid, visited, i, j - 1);
        }

        if(i + 1 < grid.length && grid[i + 1][j] == 1 && visited[i + 1][j] == false){
            str.append("S");
            traverse(grid, visited, i + 1, j);
        }

        if(j + 1 < grid[0].length && grid[i][j + 1] == 1 && visited[i][j + 1] == false){
            str.append("E");
            traverse(grid, visited, i, j + 1);
        }

        str.append("B");
    }
}
