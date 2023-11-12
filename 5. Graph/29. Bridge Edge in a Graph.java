

//     https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1



import java.util.*;

class Solution
{
    static int time = 0;
    static int res = 0;
    
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        boolean []vis = new boolean[V];
        int []dis = new int[V];
        int []low = new int[V];

        time = 0;
        res = 0;
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(adj, vis, dis, low, i, -1, c, d);
            }
        }

        return res;
    }

  
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean []vis, int []dis, int []low, int u, int p, int c, int d){
        vis[u] = true;
        dis[u] = low[u] = ++time;

        for(int v : adj.get(u)){
            if(v == p){
                continue;
            }else if(vis[v]){
                low[u] = Math.min(low[u], dis[v]);
            }else{
                dfs(adj, vis, dis, low, v, u, c, d);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > dis[u]){
                    if(c == v && d == u || c == u && d == v){
                        res = 1;
                    }
                }
            }
        }
    }
}