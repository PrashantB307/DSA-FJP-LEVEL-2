

//     https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1



class Solution {
    public static void convertToWave(int n, int[] arr) {
        
        for(int i = 1; i < n; i++){
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            i++;
        }
    }
}