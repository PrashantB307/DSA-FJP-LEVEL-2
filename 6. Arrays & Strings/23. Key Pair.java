


//     https://practice.geeksforgeeks.org/problems/key-pair5616/1


import java.util.Arrays;
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        
        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;

        while(l < r){
            int sum = arr[l] + arr[r];

            if(sum == x){
                return true;
            }else if(sum < x){
                l++;
            }else{
                r--;
            }
        }

        return false;
    }
}