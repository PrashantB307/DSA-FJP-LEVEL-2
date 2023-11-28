


//    https://practice.geeksforgeeks.org/problems/maximum-intervals-overlap5708/1


import java.util.*;
class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        
        Arrays.sort(Entry);
        Arrays.sort(Exit);

        int max = 0;
        int active = 0;
        int i = 0;
        int j = 0;
        int timimg = 0;
        
        while(i < N && j < N){
            if(Entry[i] <= Exit[j]){
                active++;
                if(max < active){
                    max = active;
                    timimg = Entry[i];
                }
                i++;
            }else{
                active--;
                j++;
            }
        }

        int[] res = new int[2];
        res[0] = max;
        res[1] = timimg;

        return res;

	}
}
