

//    https://practice.geeksforgeeks.org/problems/reverse-bits-1611130171/0?qa-rewrite=871%2Fmagnet-array-problem

//    https://leetcode.com/problems/reverse-bits/


class Sol1
{
    public int reverseBits(int n)
    {
        int  msk = 1;
        while((n & 1) == 0){
           n = n >> 1;
        }
        
        while(n != 0){
            int x = n & 1;
            
            msk = msk | x;
            n = n >> 1;
            
            if(n == 0){
                break;
            }
            msk = msk << 1;
            
        }
       return msk;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

class Sol2 {
    // you need treat n as an unsigned value
    public int reverseBits(int num) {
        int result = 0, temp = num,bit;
        
        for (int i = 0; i <= 31; i++) {
            bit = (temp >> i) & 1;
            result = result | (bit << (31 - i));
        }
        return result;
    }
}