

//     https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/


class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
    
        int[] p = new int[n + 1];
        int[] r = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            p[i] = i;
            r[i] = 0;
        }

        int removal = 0;
        int e1 = 0;
        int e2 = 0;

        for(int[] edge : edges){
            if(edge[0] == 3){
                boolean duh = union(p, r, edge[1], edge[2]);
                if(duh == false){    // duh  ==> did union happend
                    removal++;
                }else{
                    e1++;
                    e2++;
                }
            }
        }

        int[] p1 = p.clone();
        int[] r1 = r.clone();
        for(int[] edge : edges){
            if(edge[0] == 1){
                boolean duh = union(p1, r1, edge[1], edge[2]);
                if(duh == false){    
                    removal++;
                }else{
                    e1++;
                }
            }
        }

        int[] p2 = p.clone();
        int[] r2 = r.clone();
        for(int[] edge : edges){
            if(edge[0] == 2){
                boolean duh = union(p2, r2, edge[1], edge[2]);
                if(duh == false){    
                    removal++;
                }else{
                    e2++;
                }
            }
        }

        if(e1 != n - 1 || e2 != n - 1){
            return -1;
        }

        return removal;
    }

    int find(int[] p, int x){
        if(p[x] == x){
            return x;
        }else{
            p[x] = find(p, p[x]);
            return p[x];
        }
    }

    boolean union(int[] p, int[] r, int X, int Y){

        int x = find(p, X);
        int y = find(p, Y);

        if(x == y){
            return false;
        }

        if(r[x] < r[y]){
            p[x] = y;
        }else if(r[y] < r[x]){
            p[y] = p[x];
        }else{
            p[y] = x;
            r[x]++;
        }

        return true;
    }
}