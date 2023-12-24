

//    https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

//    https://www.codingninjas.com/studio/problems/longest-bitonic-sequence_1062688



class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
     
        int[] lis = new int[nums.length];   // lis = Longest Incressing Subsequence.

        for(int i = 0; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] <= nums[i]){
                    if(lis[j] > max){
                        max = lis[j];
                    }
                }
            }

            lis[i] = max + 1;
        }

        int[] lds = new int[nums.length];   // lds = Longest Decrissing Subsequence.

        for(int i = nums.length - 1; i >= 0; i--){
            int max = 0;
            for(int j = nums.length - 1; j > i; j--){
                if(nums[j] <= nums[i]){
                    if(lds[j] > max){
                        max = lds[j];
                    }
                }
            }

            lds[i] = max + 1;
        }

        int omax = 0;    // omax = Overall max.
        for(int i = 0; i < nums.length; i++){
            if(lis[i] + lds[i] - 1 > omax){
                omax = lis[i] + lds[i] - 1;
            }
        }

        return omax;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2
{
   public void findLIS(int[] nums, int[] dp, int n){
        
        for(int i=0; i<n; i++){
            dp[i]=1;

            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){ // is addition of ith point possible after jth point 
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
    }

    public void findLDS(int[] nums, int[] dp, int n){
        
        for(int i=n-1; i>=0; i--){
            dp[i]=1;

            for(int j=i+1; j<n; j++){
                if(nums[i] > nums[j]){ 
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

    }
    public int LongestBitonicSequence(int[] nums){
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        findLIS(nums,lis,n);
        findLDS(nums,lds,n);

        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans,lis[i]+lds[i]-1);
        }

        return ans;
    }
}