

//      https://www.codingninjas.com/studio/problems/z-algorithm_1112619?leftPanelTab=1

//      https://practice.geeksforgeeks.org/problems/search-pattern-z-algorithm--141631/1



import java.util.*;
class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        String str = p + "$" + s;
        
        int[] z = new int[str.length()];
        z[0] = 0;
        
        int l = 0;
        int r = 0;
        for(int i = 1; i < z.length; i++){
            if(i > r){
                l = r = i;
                while(r < z.length && str.charAt(r) == str.charAt(r - l)){
                    r++;
                }
                
                r--;
                z[i] = r - l + 1;
            } else {
                int k = i - l;
                if(z[k] == r - i + 1){
                    l = i;
                    while(r < z.length && str.charAt(r) == str.charAt(r - l)){
                        r++;
                    }

                    r--;
                    z[i] = r - l + 1;
                } else {
                    z[i] = z[k];
                }
            }
        }
        
        int count = 0;
        for(int val: z){
            if(val == p.length()){
                count++;
            }
        }
        
        return count;
	}

}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX       GFG         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        String str = pat + "$" + S;
        
        int[] z = new int[str.length()];
        z[0] = 0;
        
        int l = 0;
        int r = 0;
        for(int i = 1; i < z.length; i++){
            if(i > r){
                l = r = i;
                while(r < z.length && str.charAt(r) == str.charAt(r - l)){
                    r++;
                }
                
                r--;
                z[i] = r - l + 1;
            } else {
                int k = i - l;
                if(z[k] == r - i + 1){
                    l = i;
                    while(r < z.length && str.charAt(r) == str.charAt(r - l)){
                        r++;
                    }

                    r--;
                    z[i] = r - l + 1;
                } else {
                    z[i] = z[k];
                }
            }
        }
        
        int len = pat.length();
        for(int i = 0; i < z.length; i++){
            if(z[i] == pat.length()){
                ans.add(i - len);
            }
        }
        
        return ans;
    }
}