


//     https://leetcode.com/problems/reconstruct-itinerary/


import java.util.*;

class Solution {

    HashMap<String, PriorityQueue<String>> adj;

    public List<String> findItinerary(List<List<String>> tickets) {
        
        adj = new HashMap<>();

        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String des = ticket.get(1);

            if(adj.containsKey(src)){
                adj.get(src).add(des);
            }else{
                adj.put(src, new PriorityQueue<>());
                adj.get(src).add(des);
            }
        }

        ArrayList<String> res = new ArrayList<>();
        dfs("JFK", res);

        return res;
    }

    public void dfs(String src, ArrayList<String> res){
        if(adj.containsKey(src) == false || adj.get(src).size() == 0){
            res.add(0, src);
            return;
        } 
        
        while(adj.get(src).size() > 0){
            String nbr = adj.get(src).remove();
            dfs(nbr, res);
        }

        res.add(0, src);
    }
}
