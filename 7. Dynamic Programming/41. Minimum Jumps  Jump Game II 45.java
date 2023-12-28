

//   https://leetcode.com/problems/jump-game-ii/

//   https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1

//   https://www.codingninjas.com/studio/problems/minimum-jumps_1062693


class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int maxj = nums[0];
        int step = nums[0];
        int jump = 1;

        if(n == 1){
            return 0;
        }else{
            for(int i = 1; i < n; i++){
                if(i == n - 1){
                    return jump;
                }

                maxj = Math.max(maxj, i + nums[i]);
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


//XXXXXXXXXXXXXXXXXXXXXXXXXX   GFG   ( Jump Game )     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


class Solution2 {
    static int canReach(int[] arr, int n) {

        int maxj = arr[0];
        int step = arr[0];
        int jump = 1;

        if(n == 1){
            return 1;
        }else if(arr[0] == 0){
            return 0;
        }else{
            for(int i = 1; i < n; i++){
                if(i == n - 1){
                    return 1;
                }

                maxj = Math.max(maxj, i + arr[i]);
                step--;

                if(step == 0){
                    jump++;
                    if(i >= maxj){
                        return 0;
                    }

                    step = maxj - i;
                }
            }
        }
        System.out.println(jump);

        return 0;
        
    }
};