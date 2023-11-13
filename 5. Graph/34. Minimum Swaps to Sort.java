


//     https://practice.geeksforgeeks.org/problems/minimum-swaps/1


import java.util.*;

class Solution
{
    public int minSwaps(int nums[])
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        Arrays.sort(nums);
        int ans = 0;
        boolean[] vis = new boolean[nums.length]; 

        for(int i = 0; i < nums.length; i++){
            if(vis[i] == true || map.get(nums[i]) == i){
                continue;
            }

            vis[i] = true;

            int j = i;
            int csize = 0;
            do{
                j = map.get(nums[j]);
                vis[j] = true;
                csize++;
            }while(j != i);

            ans += csize - 1;
        }

        return ans;
    }
}