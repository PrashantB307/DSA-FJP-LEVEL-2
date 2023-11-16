


//    https://leetcode.com/problems/bricks-falling-when-hit/


class Solution {

    int[] parent;
    int[] size;
    int[] rank;
    
    int m;
    int n;
     
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        m = grid.length;
        n = grid[0].length;
        
        parent = new int[m * n + 1];
        rank = new int[m * n + 1];
        size = new int[m * n + 1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
        
        for(int[] hit: hits){
            int x = hit[0];
            int y= hit[1];
            
            if(grid[x][y] == 1){
                grid[x][y] = 2;
            } 
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    processNbrs(grid, i, j);
                }
            }
        }
        
        int[] res = new int[hits.length];
        
        for(int i = hits.length - 1; i >= 0; i--){
            int x = hits[i][0];
            int y = hits[i][1];
            
            if(grid[x][y] == 2){
                grid[x][y] = 1;
                int brickCount = size[find(0)];
                processNbrs(grid, x, y);
                int newBrickCount = size[find(0)];
                res[i] = Math.max(0, newBrickCount - brickCount - 1);
            }
        }
        
        return res;
    }
    
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
   
    void processNbrs(int[][] grid, int i, int j){
        int box = i * n + j + 1;
        
        for(int[] dir: dirs){
            int nx = i + dir[0];
            int ny = j + dir[1];
            
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                int nbox = nx * n + ny + 1;
                union(box, nbox);
            }
        }
        
        if(i == 0){
            union(box, 0);
        }
    }

    int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    void union(int X, int Y){
        int x = find(X);
        int y = find(Y);
        if(x == y){
            return;
        }

        if(rank[x] < rank[y]){
            parent[x] = y;
            size[y] += size[x];
        }else if(rank[y] < rank[x]){
            parent[y] = x;
            size[x] += size[y];
        }else{
            parent[y] = x;
            size[x] += size[y];
            rank[x]++;
        }
    }
}