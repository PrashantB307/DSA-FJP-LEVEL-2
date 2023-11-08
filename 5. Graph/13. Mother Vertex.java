


//   https://practice.geeksforgeeks.org/problems/mother-vertex/1



import java.util.ArrayList;
import java.util.Arrays;

class Solution
{
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int mv = -1;
        boolean[] vis = new boolean[V];
        for(int v = 0; v < V; v++){
            if(!vis[v]){
                dfs(v, vis, adj);
                mv = v;
            }
        }

        Arrays.fill(vis, false);
        dfs(mv, vis, adj);

        for(int v = 0; v < V; v++){
            if(vis[v] == false){
                return -1;
            }
        }

        return mv;
    }

    public void dfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>>adj){
        vis[v] = true;

        for(int n : adj.get(v)){
            if(!vis[n]){
                dfs(n, vis, adj);
            }
        }
    }
}