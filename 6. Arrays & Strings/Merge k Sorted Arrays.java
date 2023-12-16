

//    https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1


import java.util.*;
class Solution
{
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < K; i++){
            for(int j = 0; j < K; j++){
                pq.add(arr[i][j]);
            }
        }

        while(pq.size() > 0){
            list.add(pq.remove());
        }

        return list;
    }
}