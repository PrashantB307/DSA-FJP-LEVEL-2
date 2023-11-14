


//     https://practice.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1


import java.util.*;

class Solution{

    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
       int count = 0;
       for(int v = 0; v < V; v++){
           if(adj.get(v).size() % 2 == 1){
               count++;
           }
       }
       
       return count == 0;
    }
}
