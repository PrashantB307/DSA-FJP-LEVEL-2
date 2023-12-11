


//    https://practice.geeksforgeeks.org/problems/magic-triplets4003/1


class Solution{
    public int countTriplets(int[] arr){
       
        int n = arr.length;
        int ans = 0;
        
        for(int i = 1; i < n - 1; i++){
            int l = 0, r = 0;
            for(int j = 0; j < i ; j++){
                if(arr[j] < arr[i]){
                   l++;
                }
            }
             
            for(int j = i + 1; j < n; j++){
                if(arr[i] < arr[j]){
                    r++;
                }
            }
            
            ans += l * r;
        }
        
        return ans;
    }
}