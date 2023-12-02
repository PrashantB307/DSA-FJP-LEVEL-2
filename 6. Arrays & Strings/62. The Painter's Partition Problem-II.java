

//     https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1


 class Solution{
    static long minTime(int[] arr, int n, int k){
        
        long lta = Long.MIN_VALUE;  // lta = lowest time allowed
        long hta = 0;   //  hta = highest time allowed

        for(int val : arr){
            hta += val;
            lta = Math.max(val, lta);
        }

        while(lta < hta){
            long ta = (lta + hta) / 2;   // ta = time allowed

            int pr = 1;    // pr = painters required 
            int cp = 0;    // cp = current painter

            for(int val : arr){
                if(cp + val <= ta){
                    cp += val;
                }else{
                    pr++;
                    cp = val;
                }
            }

            if(pr > k){
                lta = ta + 1;
            }else{
                hta = ta;
            }
        }

        return lta;
    }
}
