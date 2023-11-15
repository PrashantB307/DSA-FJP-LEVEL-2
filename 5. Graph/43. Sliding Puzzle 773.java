


//     https://leetcode.com/problems/sliding-puzzle/


import java.util.*;

class Solution {

    class Pair {
        String config;
        int level;
    }

    public int slidingPuzzle(int[][] board) {
        
        HashSet<String> vis = new HashSet<>();
        
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        Pair rootp = new Pair();

        rootp.config = getConfig(board);
        rootp.level = 0;
        dq.add(rootp);

        while(dq.size() > 0){
            Pair rem = dq.remove();
            if(vis.contains(rem.config)){
                continue;
            }
            vis.add(rem.config);

            if(rem.config.equals("123450")){
                return rem.level;
            }

            int [][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

            int idx = rem.config.indexOf('0');

            for(int i : dirs[idx]){
                String nconfig = swap(rem.config, idx, i);
                if(vis.contains(nconfig) == false){
                    Pair np = new Pair();
                    np.config = nconfig;
                    np.level = rem.level + 1;
                    dq.add(np);
                }
            }
        }

        return -1;
    }

    public String getConfig(int[][] board){
        StringBuilder sb = new StringBuilder();

        for(int[] row : board){
            for(int val : row){
                sb.append(val);
            }
        }

        return sb.toString();
    }

    public String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);

        char chi = str.charAt(i);
        char chj = str.charAt(j);

        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);

        return sb.toString();
    }
}