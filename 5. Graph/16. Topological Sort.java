


//    https://practice.geeksforgeeks.org/problems/topological-sort/1


import java.util.*;
class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        int []ans = new int[V];

        for(int v = 0; v < V; v++){
            if(!vis[v]){
                tsort(v, vis, adj, st);
            }
        }
        
        int i = 0;
        while(st.size() > 0){
            ans[i] = st.pop();
            i++;
        }

        return ans;
    }

    static void tsort(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj,  Stack<Integer> st){
        
        vis[v] = true;
        for(int n: adj.get(v)){
            if(!vis[n]){
                tsort(n, vis, adj, st);
            }
        }
        
        st.push(v);
    }
}