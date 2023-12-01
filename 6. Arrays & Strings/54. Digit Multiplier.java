

//    https://practice.geeksforgeeks.org/problems/digit-multiplier3000/1


class Solution {
    static String getSmallest(Long N) {
        
        StringBuilder sb = new StringBuilder();
        
        if(N < 10){
            return N + "";
        }

        for(int div = 9; div > 1; div--){
            while( N % div == 0){
                N = N / div;
                sb.append(div);
            }
        }

        if(N >= 10){
            return "-1";
        }

        return sb.reverse().toString();
    }
}