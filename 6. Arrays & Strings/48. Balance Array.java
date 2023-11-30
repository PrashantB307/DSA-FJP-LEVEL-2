

//      https://www.interviewbit.com/problems/balance-array/


import java.util.*;
class Solution {
    public int solve(ArrayList<Integer> A) {

        int es = 0;
        int os = 0;

        for(int i = 0; i  <A.size(); i++){
            if(i % 2 == 0){
                es += A.get(i);
            }else{
                os += A.get(i);
            }
        }

        int los = 0;
        int les = 0;
        int ans = 0;

        for(int i = 0; i < A.size(); i++){
            if(i % 2 == 0){
                int res = es - les - A.get(i);
                int ros = os - los;

                if(los + res == les + ros){
                    ans++;
                }

                les += A.get(i);
            }else{
                int res = es - les;
                int ros = os - los - A.get(i);

                if(los + res == les + ros){
                    ans++;
                }

                los += A.get(i);
            }
        }

        return ans;
    }
}
