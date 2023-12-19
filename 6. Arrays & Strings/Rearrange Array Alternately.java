

//     https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1


class Solution{
    
    public static void rearrange(long arr[], int n){
        
        int l = 0;
        int r = n - 1;
        long max= arr[n - 1] + 1;
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                arr[i] += (arr[r] % max) * max;
                r--;
            }else{
                arr[i] += (arr[l] % max) * max;
                l++;
            }
        }
        
        for(int i = 0; i < n; i++){
            arr[i] = arr[i] / max;
        }
        
    }
    
}
