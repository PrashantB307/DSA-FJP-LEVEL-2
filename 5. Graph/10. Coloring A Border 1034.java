

//    https://leetcode.com/problems/coloring-a-border/



import java.util.*;
class Solution { 

    class Pair{
        int i;
        int j;
        boolean border;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        Pair p = new Pair(row, col);
        p.border = isBorder(grid, row, col);
        queue.add(p);

        ArrayList<Pair> res = new ArrayList<>();
        int orgc = grid[row][col];

        while(queue.size() > 0){
            Pair rem = queue.remove();

            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;

            if(rem.border){
                res.add(rem);
            }

            addNbr(rem.i - 1, rem.j, orgc, visited, grid, queue);
            addNbr(rem.i + 1, rem.j, orgc, visited, grid, queue);
            addNbr(rem.i, rem.j - 1, orgc, visited, grid, queue);
            addNbr(rem.i, rem.j + 1, orgc, visited, grid, queue);
        }

        for(Pair pair : res){
           grid[pair.i][pair.j] = color;
        }

        return grid;
        
    }

    public void addNbr(int i, int j, int orgc, boolean[][] visited, int[][] grid, ArrayDeque<Pair> queue){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != orgc || visited[i][j] == true){
            return;
        }
        
        Pair p = new Pair(i, j);
        p.border = isBorder(grid, i, j);
        queue.add(p);
    }

    boolean isBorder(int[][] grid, int i, int j){

        if(i == 0){
            return true;
        }if(j == 0){
            return true;
        }if(i == grid.length - 1){
            return true;
        }if(j == grid[0].length - 1){
            return true;
        }else{
            int color = grid[i][j];
            if(grid[i - 1][j] != color){
                return true;
            }else if(grid[i + 1][j] != color){
                return true;
            }
            else if(grid[i][j - 1] != color){
                return true;
            }
            else if(grid[i][j + 1] != color){
                return true;
            }else{
                return false;
            }
        }
    }
}


//XXXXXXXXXXXXXXXXXXXXXXXX ========>   D F S    <======== XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX



class Solution2 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oc = grid[row][col];
        traverse(grid, row, col, oc);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == -oc){
                    grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }
    
    public void traverse(int[][] grid, int i, int j, int oc){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oc){
            return;
        }
        
        grid[i][j] = -oc;
        
        traverse(grid, i - 1, j, oc);
        traverse(grid, i + 1, j, oc);
        traverse(grid, i, j - 1, oc);
        traverse(grid, i, j + 1, oc);
        
        if(i > 0 && j > 0 && i < grid.length - 1 && j < grid[0].length - 1 &&
           Math.abs(grid[i - 1][j]) == oc &&
           Math.abs(grid[i + 1][j]) == oc &&
           Math.abs(grid[i][j - 1]) == oc &&
           Math.abs(grid[i][j + 1]) == oc){
            grid[i][j] = oc;
        }
    }
}

