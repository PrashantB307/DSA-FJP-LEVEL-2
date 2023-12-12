

//     https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

//     https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1 


class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        int[] pos = new int[n/ 2];
        int[] neg = new int[n / 2];
        int j = 0;
        int k = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                pos[j] = nums[i];
                j++;
            }else{
                neg[k] = nums[i];
                k++;
            }
        }

        int[] ans = new int[n];
        for(int i = 0; i < n / 2; i++){
            ans[2 * i] = pos[i];
            ans[2 * i + 1] = neg[i];
        } 
        
        return ans;
    }
}

// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    void rearrange(int arr[], int n) {
     
        int start = 0;
        int end = n - 1;
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++){
            if(arr[i] >= 0){
                nums[start++] = arr[i];
            } 
            else if(arr[i] < 0){
                nums[end--] = arr[i];
            }
        }
        
        int s = 0;
        int e = n - 1;
        for(int i = 0; i < n; ){
	        if(s < start){
	            arr[i] = nums[s++];
	            i++;
	        }
	        if(e > end){
	            arr[i] = nums[e--];
	            i++;
	        }
	    }
        
        
    }
}