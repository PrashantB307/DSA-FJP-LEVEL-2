

//    https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1

//    https://www.codingninjas.com/studio/problems/3-sum-smaller_3161884

//    https://leetcode.com/problems/count-good-triplets/description/


import java.util.* ;
class Solution {
	public static int threeSumSmaller(int n, int[] arr, int sum) {
		int c = 0;
        Arrays.sort(arr);
        
        for(int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int add = arr[i] + arr[j] + arr[k];
                if(add < sum){
                    c += k - j;
                    j++;
                    
                }else{
                    k--;
                }
            }
        }
        return c;
	}
}


//XXXXXXXXXXXXXXXXXXXXXXXXXXX=====>   LEETCODE    <======XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX



class Solution2 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        
        int cnt = 0;
        int n = arr.length;
        
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                    cnt++;
                }
                }
            }
        }

        return cnt;
    }
}