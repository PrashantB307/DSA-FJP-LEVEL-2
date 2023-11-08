

//    https://leetcode.com/problems/swim-in-rising-water/



import java.util.PriorityQueue;

class Solution {

    class Pair implements Comparable<Pair>{
        int i;
        int j;
        int time;

        Pair(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }

        public int compareTo(Pair o){
            return this.time - o.time;
        }
    }

    public int swimInWater(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0, grid[0][0]));

        while(pq.size() > 0){
            Pair rem = pq.remove();

            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;

            if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1){
                return rem.time;
            }

            addNbr(rem.i - 1, rem.j, rem.time, visited, grid, pq);
            addNbr(rem.i + 1, rem.j, rem.time, visited, grid, pq);
            addNbr(rem.i, rem.j - 1, rem.time, visited, grid, pq);
            addNbr(rem.i, rem.j + 1, rem.time, visited, grid, pq);

        }

        return -1;
    }

    public void addNbr(int i, int j, int time, boolean[][] visited, int[][] grid,  PriorityQueue<Pair> pq){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true){
            return;
        }

        pq.add(new Pair(i, j, Math.max(time, grid[i][j])));
    }
}