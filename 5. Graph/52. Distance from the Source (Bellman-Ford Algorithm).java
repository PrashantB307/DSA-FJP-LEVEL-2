

//    https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1


import java.util.*;
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int []ans = new int[V];
        Arrays.fill(ans, 100000000);
        ans[S] = 0;

        for(int i = 1; i <= V - 1; i++){
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int p = edge.get(2);

                if(ans[u] == 100000000){
                    continue;
                }else if(ans[v] == 100000000){
                    ans[v] = ans[u] + p;
                }else{
                    ans[v] = Math.min(ans[v], ans[u] + p);
                }
            }
        }

        return ans;
    }
}