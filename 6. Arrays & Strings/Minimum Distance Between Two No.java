

//   https://www.geeksforgeeks.org/problems/minimum-distance-between-two-numbers/1

//   https://www.codingninjas.com/studio/problems/minimum-distance-between-two-numbers_1062637?leftPanelTabValue=PROBLEM



class Solution {
    int minDist(int arr[], int n, int x, int y) {
        int inx = -1;
        int inx2 = -1;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(arr[i] == x){
                inx = i;
            } 
            if(arr[i] == y){
               inx2 = i;
            }
            if(inx != -1 && inx2 != -1) {
                ans = Math.min(ans, Math.abs(inx - inx2));
            }
        }
    
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        
        return ans;
    }
}
