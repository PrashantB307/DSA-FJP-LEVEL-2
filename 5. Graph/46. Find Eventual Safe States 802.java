

//     https://leetcode.com/problems/find-eventual-safe-states/

//     https://practice.geeksforgeeks.org/problems/eventual-safe-states/1


import java.util.*;
class Solution {

    int[] vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        ArrayList<Integer> res = new ArrayList<>();
        vis = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
            boolean safe = dfs(i, graph);
            if(safe){
                res.add(i);
            }
        }

        return res;
    }

    public boolean dfs(int v, int[][] graph){
        if(vis[v] == 2){
            return true;
        }else if(vis[v] == 1){
            return false;
        }else{
            vis[v] = 1;

            for(int n : graph[v]){
                boolean isNbrSafe = dfs(n, graph);
                if(isNbrSafe == false){
                    return false;
                }
            }

            vis[v] = 2;
            return true;
        }
    }
}