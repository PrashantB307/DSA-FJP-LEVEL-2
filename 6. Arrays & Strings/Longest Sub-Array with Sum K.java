

//      https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

//      https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505



import java.util.*;
class Solution{
   
    public static int lenOfLongSubarr (int A[], int N, int K) {
       
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < N; i++) {
            sum += A[i];
            
            if (sum == K) {
                len = Math.max(len, i + 1);
            }

            int remain = sum - K;
            
            if (mp.containsKey(remain)) {
                int maxi = i - mp.get(remain);
                len = Math.max(len, maxi);
            }

            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }

        return len;
    }
    
    
}