


//     https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1


import java.util.*;
class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
       
        Arrays.sort(arr);

        int i = 0;
        int j = 1;
        
        while(j < size){
            int diff = arr[j] - arr[i];

            if(diff == n){
                return true;
            }else if(diff > n){
                i++;
                if(i == j){
                    j++;
                }
            }else{
                j++;
            }
        }

        return false;
    }
}