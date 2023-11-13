

//     https://leetcode.com/problems/redundant-connection-ii/


import java.util.*;

class Solution {

    int []dsu;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);

        boolean twopf = false;
        int []e1 = null;
        int []e2 = null;

        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];

            if(parent[to] == -1){
                parent[to] = from;
            }else{
                twopf = true;
                e2 = edges[i];
                e1 = new int[] {parent[to], to};
                break;
            }
        }

        dsu = new int[edges.length + 1];
        for(int i = 0; i <= edges.length; i++){
            dsu[i] = i;
        }

        if(twopf == false){
            int []res = null;

            for(int i = 0; i < edges.length; i++){
                int from = edges[i][0];
                int to = edges[i][1];

                int fromLead = find(from);
                if(to == fromLead){
                    res = edges[i];
                    break;
                }else{
                    dsu[to] = fromLead;
                }
            }

            return res;
        }else{
            boolean noCycleFlag = true;
            for(int i = 0; i < edges.length; i++){
                if(edges[i] == e2){
                    continue;
                }
                int from = edges[i][0];
                int to = edges[i][1];

                int fromLead = find(from);
                if(to == fromLead){
                    noCycleFlag = false;
                    break;
                }else{
                    dsu[to] = fromLead;
                }
            }

            if(noCycleFlag == true){
                return e2;
            }else{
                return e1;
            }
        }
    }

    int find(int x){
        if(dsu[x] == x){
            return x;
        }else{
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }
}