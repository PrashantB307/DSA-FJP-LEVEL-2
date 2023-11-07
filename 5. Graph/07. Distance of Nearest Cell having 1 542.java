

//    https://leetcode.com/problems/01-matrix/

//    https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1


import java.util.ArrayDeque;

class Solution {

    class Pair {
        int i;
        int j;
        int level;
        
        Pair(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        
        boolean [][] visited = new boolean[mat.length][mat[0].length];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int [][] ans = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        while(queue.size() > 0){

            Pair rem = queue.remove();

            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;

            ans[rem.i][rem.j] = rem.level;

            addNbr(rem.i - 1, rem.j, rem.level + 1, visited, queue);
            addNbr(rem.i + 1, rem.j, rem.level + 1, visited, queue);
            addNbr(rem.i, rem.j - 1, rem.level + 1, visited, queue);
            addNbr(rem.i, rem.j + 1, rem.level + 1, visited, queue);
        }

        return ans;
    }

    void addNbr(int i, int j, int level, boolean [][] visited, ArrayDeque<Pair> queue){
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] == true){
            return;
        }

        queue.add(new Pair(i, j, level));
    }

} 