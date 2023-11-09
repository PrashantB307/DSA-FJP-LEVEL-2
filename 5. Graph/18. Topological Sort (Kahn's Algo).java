


//    https://practice.geeksforgeeks.org/problems/topological-sort/1




import java.util.*;
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int []tsort = new int[V];

        int [] in = new int[V];
        for(int i = 0; i < V; i++){
            for(int n : adj.get(i)){
                in[n]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int v = 0; v < V; v++){
            if(in[v] == 0){
                queue.add(v);
            }
        }

        int idx = 0;
        while(queue.size() > 0){
            int rem = queue.remove();
            tsort[idx] = rem;
            idx++;

            for( int n : adj.get(rem)){
                in[n]--;

                if(in[n] == 0){
                    queue.add(n);
                }
            }
        }

        if(idx < V){
            return new int[]{};
        }

        return tsort;
    }
}