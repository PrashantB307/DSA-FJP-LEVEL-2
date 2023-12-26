

//   https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1

//   https://www.codingninjas.com/studio/problems/count-subsequences-with-given-form_3131824



class Solution
{
    int mod = 1000000007;
    public int fun(String s)
    {
        long a = 0;
        long ab = 0;
        long abc = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == 'a'){
                a = (2 * a + 1) % mod;
            }else if(ch == 'b'){
                ab = (2 * ab + a) % mod;
            }else if(ch == 'c'){
                abc = (2 * abc + ab) % mod;
            }
        }
        
        return (int)abc;
    }
}