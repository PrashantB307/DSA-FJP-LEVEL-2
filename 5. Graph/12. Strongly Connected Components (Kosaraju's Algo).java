

//    https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1



import java.util.ArrayList;
import java.util.Stack;

class Solution
{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //  Fill Stack
        Stack<Integer> st = new Stack<>();
        boolean[] vis1 = new boolean[V];

        for(int v = 0; v < V; v++){
            if(!vis1[v]){
                dfs1(v, adj, vis1, st);
            }
        }

        //  Transpose
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<>();
        for(int v = 0; v < V; v++){
            tsp.add(new ArrayList<>());
        }

        for(int v = 0; v < V; v++){
            for(int n : adj.get(v)){
                tsp.get(n).add(v);
            }
        }

        //  SCC
        int count = 0;
        boolean[] vis2 = new boolean[V];
        while(st.size() > 0){
            int v = st.pop();
            if(!vis2[v]){
                dfs2(v, tsp, vis2);
                count++;
            }
        }

        return count;
    }

    public void dfs1(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[v] = true;
        for(int n : adj.get(v)){
            if(!vis[n]){
                dfs1(n, adj, vis, st);
            }
        }

        st.push(v);
    }

    public void dfs2(int v, ArrayList<ArrayList<Integer>> tsp, boolean[] vis){
        vis[v] = true;
        for(int n : tsp.get(v)){
            if(!vis[n]){
                dfs2(n, tsp, vis);
            }
        }
    }
}
 