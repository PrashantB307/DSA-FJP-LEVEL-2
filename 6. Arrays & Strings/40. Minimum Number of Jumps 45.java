

//      https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1

//      https://leetcode.com/problems/jump-game-ii/


class Solution{
    static int minJumps(int[] arr){
        int n = arr.length;

        int maxj = arr[0];    // Max Jump
        int step = arr[0];
        int jump = 1;  

        if(n == 1){
            return 0;
        }else if(arr[0] == 0){
            return -1;
        }else{
            for(int i = 1; i < n; i++){
                if(i == n - 1){
                    return jump;
                }

                maxj = Math.max(maxj, i + arr[i]);
                step--;

                if(step == 0){
                    jump++;
                    if(i >= maxj){
                        return -1;
                    }

                    step = maxj - i;
                }
            }
        }

        return jump;
    }
}
