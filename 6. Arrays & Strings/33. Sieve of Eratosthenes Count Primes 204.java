

//     https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1

//     https://leetcode.com/problems/count-primes/description/


import java.util.*;
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
       
        if(N < 2){
            return new ArrayList<>();
        }

        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i * i < N; i++){
            if(primes[i] == false){
                continue;
            }

            for(int j = i; j * i <= N; j++){
                primes[i * j] = false;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < primes.length - 1; i++){
            if(primes[i] == true){
                ans.add(i);
            }
        }

        return ans;
    }
}

// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    public int countPrimes(int n) {
        
        if(n < 2){
            return 0;
        }

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i * i < n; i++){
            if(primes[i] == false){
                continue;
            }

            for(int j = i; j * i <= n; j++){
                primes[i * j] = false;
            }
        }

        int count = 0; 
        for(int i = 0; i < primes.length - 1; i++){
            if(primes[i] == true){
               count++;
            }
        }

        return count;
    }
}