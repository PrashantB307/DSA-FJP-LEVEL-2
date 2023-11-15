


//   https://leetcode.com/problems/k-similar-strings/


import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        
        HashSet<String> vis = new HashSet<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        
        q.add(s1);
        int level = 0;

        while(q.size() > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String rem = q.remove();

                if(vis.contains(rem)){
                    continue;
                }

                vis.add(rem);

                if(rem.equals(s2)){
                    return level;
                }

                for(String s : getNbr(rem, s2)){
                    if(!vis.contains(s)){
                        q.add(s);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    public ArrayList<String> getNbr(String rem ,String s2){
        ArrayList<String> res = new ArrayList<>();
        
        int idx = -1;
        for(int i = 0; i < rem.length(); i++){
            if(rem.charAt(i) != s2.charAt(i)){
                idx = i;
                break;
            }
        }

        for(int j = idx + 1; j < rem.length(); j++){
            if(rem.charAt(j) == s2.charAt(idx)){
                String s = swap(rem, idx, j);
                res.add(s);
            }
        }

        return res;
    }

    public String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);

        char chi = str.charAt(i);
        char chj = str.charAt(j);

        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);

        return sb.toString();
    }
}
