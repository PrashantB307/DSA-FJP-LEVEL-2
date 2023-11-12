


//    https://practice.geeksforgeeks.org/problems/articulation-point2616/1


import java.util.*;

class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean []vis = new boolean[V];
        int []dis = new int[V];
        int []low = new int[V];
        boolean []aps = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(adj, vis, dis, low, aps, i, -1);
            }
        }

        int count = 0;
        for(boolean ap : aps){
            if(ap){
                count++;
            }
        }

        if(count == 0){
            return new int[]{-1};
        }else{
            int []res = new int[count];
            int idx = 0;
            for(int i = 0; i < aps.length; i++){
                if(aps[i] == true){
                    res[idx] = i;
                    idx++;
                }
            }

            return res;
        }
    }

    int time = 0;
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean []vis, int []dis, int []low, boolean []aps, int u, int p){
        vis[u] = true;
        dis[u] = low[u] = ++time;

        int c = 0;
        for(int v : adj.get(u)){
            if(v == p){
                continue;
            }else if(vis[v]){
                low[u] = Math.min(low[u], dis[v]);
            }else{
                c++;
                dfs(adj, vis, dis, low, aps, v, u);
                low[u] = Math.min(low[u], low[v]);

                if(p != -1 && low[v] >= dis[u]){
                    aps[u] = true;
                }
            }
        }

        if(p == -1 && c > 1){
            aps[u] = true;
        }
    }
}