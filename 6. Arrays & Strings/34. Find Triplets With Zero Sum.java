


//     https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1


import java.util.*;
class Solution
{
	public boolean findTriplets(int arr[] , int n)
    {
        boolean found = false;
        Arrays.sort(arr);
        
        for(int i = 0; i < n; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if( sum == 0){
                    found = true;
                    break;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
               
               if(found){
                   break;
               }
            }
        }
        return found;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2
{
	public boolean findTriplets(int arr[] , int n)
    {
        boolean found = false;
        
        for(int i = 0; i < n ; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i + 1; j < n ;j++){
                int sum = -(arr[i] + arr[j]);
                if(set.contains(sum)){
                    found = true;
                    break;
                }
                set.add(arr[j]);
            }
            
            if(found){
                break;
            }
        }
        
        return found;
    }
}