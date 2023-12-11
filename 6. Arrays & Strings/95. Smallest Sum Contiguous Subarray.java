

//     https://practice.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1


class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
     
      int currSum = a[0];
      int minSum = a[0];
       
      for(int i = 1; i < size; i++){
          currSum = Math.min(currSum + a[i], a[i]);
          minSum = Math.min(minSum , currSum);
      }
       
      return minSum;
      
    }
}