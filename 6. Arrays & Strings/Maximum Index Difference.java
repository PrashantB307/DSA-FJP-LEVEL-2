

//     https://practice.geeksforgeeks.org/problems/maximum-index3307/1 


class Solution {

    int maxIndexDiff(int arr[], int n) {
  
        int[] max = new int[n];
        int[] min = new int[n];
        
        min[0] = arr[0];
        max[n - 1] = arr[n - 1];
        
        for(int i = 1; i < n; i++){
            min[i] = Math.min(min[i - 1], arr[i]);
            max[n - i - 1] = Math.max(max[n - i], arr[n - i - 1]);
        }
        
        int len = 0;
        int i = 0;
        int j = 0;
        
        while( i < n && j < n){
            if(min[i] <= max[j]){
                len = Math.max(len, j - i);
                j++;
            }else{
                i++;
            }
        }
        
        return len;
    }
}