

//      https://practice.geeksforgeeks.org/problems/kth-smallest-factor2345/1

//      https://leetcode.com/problems/the-kth-factor-of-n/


//------------------------   O(sqrt(N)) -------------------------->


import java.util.*;
class Solution {
    static int kThSmallestFactor(int N , int K) {
        
        TreeSet<Integer> res = new TreeSet<>();
        
        for(int i = 1; i * i <= N; i++){
            if(N % i == 0){
                res.add(i);
                
                if((N / i) != i && i != 1){
                    res.add(N / i);
                }
            }
       }
       
       res.add(N);
       
       if(res.size() < K){
           return -1;
       }
       
       for(int i : res){
           K--;
           if(K == 0){
               return i;
           }
           
       }
       
       return -1;
    }
};


// XXXXXXXXXXXXXXXXXXXXXXXXXX     O(N)     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public int kthFactor(int n, int k) {
         for(int i = 1; i <= n; i++){
            if(n % i == 0){
                k--;
                if(k == 0){
                    return i;
                }
            }
        }
        
        return -1;
    }
}