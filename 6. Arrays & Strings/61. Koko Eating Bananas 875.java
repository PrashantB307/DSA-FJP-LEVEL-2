

//      https://leetcode.com/problems/koko-eating-bananas/

//      https://practice.geeksforgeeks.org/problems/koko-eating-bananas/1


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int las = 1;   // las = lowest allowed speed
        int has = 0;   // has = highest allowed speed

        for(int pile : piles){
            has = Math.max(pile, has);
        }

        while(las < has){

            int as = (las + has) / 2;   // as = allowed speed

            int totalTime = 0;
            for(int pile : piles){
                int time = (pile + as - 1) / as;
                totalTime += time;
            }

            if(totalTime > h){
                las = as + 1;
            }else{
                has = as;
            }
        }

        return las;
    }
}
