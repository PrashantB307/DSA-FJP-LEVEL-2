

//   https://www.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1

//   https://www.codingninjas.com/studio/problems/maximum-sum-of-non-adjacent-elements_843261


class Solution {
    int findMaxSum(int arr[], int n) {
        
        if(n == 1){
            return arr[0];
        }else if(n == 2){
            return Math.max(arr[0], arr[1]);
        }

        int a = arr[0];
        int b = arr[1];
        for(int i = 2; i < n; i++){
            int c = Math.max(b, a + arr[i]);
            a = b;
            b = c;
        }

        return b;
    }
}