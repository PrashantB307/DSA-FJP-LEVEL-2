


//   https://leetcode.com/problems/bus-routes/


import java.util.*;
class Solution {

    class Pair {
        int bus;
        int csf;

        Pair (int bus, int csf){
            this.bus = bus;
            this.csf = csf;
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {

        if(source == target){
            return 0;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int bus = 0; bus < routes.length; bus++){
            for(int stop : routes[bus]){
                if(map.containsKey(stop) == false){
                    map.put(stop, new HashSet<>());
                }
                map.get(stop).add(bus);
            }
        }

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for(int bsrc : map.get(source)){
            queue.add(new Pair(bsrc, 1));
        }

        boolean[] visited = new boolean[routes.length];

        while(queue.size() > 0){
            Pair rem = queue.remove();

            if(visited[rem.bus] == true){
                continue;
            }
            visited[rem.bus] = true;

            for(int rstop : routes[rem.bus]){
                if(rstop == target){
                    return rem.csf;
                }
            }

            for(int rstop  :routes[rem.bus]){
                for(int bus : map.get(rstop)){
                    if(visited[bus] == false){
                        queue.add(new Pair(bus, rem.csf + 1));
                    }
                }
            }
        }

        return -1;

    }
}



//  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX



class Solution2 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }

        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                adj.computeIfAbsent(routes[i][j], k-> new ArrayList<>()).add(i);
            }
        }

        int ans = 0;
        HashSet<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        while(!q.isEmpty()){
            int n = q.size();
            ans++;

            while(n-- > 0){
                int val = q.poll();

                for(int it : adj.get(val)){
                    if(vis.contains(it)){
                        continue;
                    }

                    vis.add(it);

                    for(int i = 0; i < routes[it].length; i++){
                        if(target == routes[it][i]){
                            return ans;
                        }

                        q.offer(routes[it][i]);
                    }
                }
            }
        }

        return -1;
    }
}