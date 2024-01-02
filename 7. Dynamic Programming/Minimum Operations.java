

//    https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1


class Solution
{
    public int minOperation(int n)
    {
        int c = 0;
        if(n == 1){
            return 1 + c;
        }
        
        if(n % 2 == 0){
            c = 1 + minOperation(n / 2);
        }else{
            c = 1 + minOperation(n - 1);
        }
        
        return c;
    }
}