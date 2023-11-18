

//    https://practice.geeksforgeeks.org/problems/find-the-maximum-flow2126/1


import java.util.*;
class Solution 
{ 
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        int mflow = 0;

        int[] par = new int[N + 1];
        
        int[][] graph = new int[N + 1][N + 1];
        int[][] rgraph = new int[N + 1][N + 1];

        for(ArrayList<Integer> edge : Edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph[u][v] += w;
            graph[v][u] += w;
            
            rgraph[u][v] += w;
            rgraph[v][u] += w;
        }

        while(pathFound(par, rgraph) == true){
            int flow = Integer.MAX_VALUE;

            int v = N;
            while(v != 1){
                int pv = par[v];
                int price = rgraph[pv][v];

                if(price < flow){
                    flow = price;
                }

                v = pv;
            }

            v = N;
            while(v != 1){
                int pv = par[v];
                rgraph[pv][v] -= flow;
                rgraph[v][pv] += flow;

                v = pv;
            }

            mflow += flow; 
        }

        return mflow;
    }

    boolean pathFound(int[] par, int[][] rgraph){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[par.length];

        queue.add(1);

        while(queue.size() != 0){
            int rem = queue.remove();

            if(vis[rem]){
                continue;
            }

            vis[rem] = true;

            if(rem == par.length - 1){
                return true;
            }

            for(int n = 1; n < rgraph.length; n++){
                if(rgraph[rem][n] > 0 && !vis[n]){
                    queue.add(n);
                    par[n] = rem;
                }
            }
        }

        return false;
    }
}
