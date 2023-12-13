

//    https://practice.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1

//    https://practice.geeksforgeeks.org/problems/pairs-which-are-divisible-by-41920/1

//    https://www.codingninjas.com/studio/problems/pair-count_3116719



class Solution {

	public static int pairCount(int[] arr, int k) {
		int [] fmap = new int[k];

        int res = 0;
        for(int i : arr){
            int val = i % k;

            if(val == 0){
                res += fmap[0];
            }else{
                res += fmap[k - val];
            }

            fmap[val]++;
        }

        return res;
	}

}