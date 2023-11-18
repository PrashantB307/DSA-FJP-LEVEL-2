

//   https://practice.geeksforgeeks.org/problems/transitive-closure-of-a-graph0930/1


import java.util.*;
class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(i == j){
                        graph[i][j] = 1;
                    }
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j < N; j++){
                row.add(graph[i][j]);
            }
            
            res.add(row);
        }
        
        return res;
    }
}