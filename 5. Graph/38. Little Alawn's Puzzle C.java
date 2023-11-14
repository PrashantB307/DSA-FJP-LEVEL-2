


//     https://codeforces.com/contest/1534/problem/C


import java.util.*;
class codeforces {

    static int[] parent;
    static int[] rank;

    public static void solve(int[] r1, int[] r2){
        
        parent = new int[r1.length];
        rank = new int[r1.length];

        for(int i = 0; i < r1.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < r1.length; i++){
            map1.put(r1[i], i);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < r2.length; i++){
            map2.put(r2[i], i);
        }

        for(int i = 0; i < r1.length; i++){
            int ilead = find(i);

            int x = map2.get(r1[i]);
            int xlead = find(x);
            if(ilead != xlead){
                union(ilead, xlead);
            }

            int y = map1.get(r2[i]);
            int ylead = find(y);
            if(ilead != ylead){
                union(ilead, ylead);
            }
        }

        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                count++;
            }
        }

        int MOD = 1000000007;
        int ans = 1;

        for(int i = 1; i <= count; i++){
            ans = ((ans % MOD) * (2 % MOD)) % MOD;
        }

        System.out.println(ans);

    }

    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static void union(int x, int y){
        if(rank[x] < rank[y]){
            parent[x] = y;
        }else{
            parent[y] = x;

            if(rank[x] == rank[y]){
                rank[x]++;
            }
        }
    }
}