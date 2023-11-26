

//     https://leetcode.com/problems/consecutive-numbers-sum/description/

//     https://practice.geeksforgeeks.org/problems/count-of-sum-of-consecutives3741/1

//     https://practice.geeksforgeeks.org/problems/consecutive-numbers-for-sum3132/1

//     https://practice.geeksforgeeks.org/problems/sum-of-consecutives1030/1


class Solution {
    public int consecutiveNumbersSum(int n) {
        
        int res = 0;
        int k = 1;
        int check = k * ( k - 1) / 2;

        while(check < n){
            if((n - check) % k == 0){
                res++;
            }

            k++;
            check = k * ( k - 1) / 2;
        }
        
        return res;
        
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    static int getCount(int N) {
        int res = 0;
        int k = 1;
        int check = k * ( k - 1) / 2;

        while(check < N){
            if((N - check) % k == 0){
                res++;
            }

            k++;
            check = k * ( k - 1) / 2;
        }
        
        return res - 1;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution3 {
    static String isSumOfConsecutive(int N) {
        int res = 0;
        int k = 1;
        String y = "Yes";
        String n = "No";
        int check = k * ( k - 1) / 2;

        while(check < N){
            if((N - check) % k == 0){
                res++;
            }

            k++;
            check = k * ( k - 1) / 2;
        }
        
        res = res - 1;
        if(res > 0){
            return y;
        }
        
        
        return n;
    }
}


//  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

class Solution4 {
    static long canBeSumofConsec(long n) { 
        long res = 0;
        long k = 1;
        long check = k * ( k - 1) / 2;

        while(check < n){
            if((n - check) % k == 0){
                res++;
            }
            if(res - 1 > 0){
            return 1;
           }

            k++;
            check = k * ( k - 1) / 2;
        }
        
        return 0;
    }
}