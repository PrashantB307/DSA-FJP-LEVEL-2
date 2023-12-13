

//   https://practice.geeksforgeeks.org/problems/repeated-character2058/1
 
//   https://www.codingninjas.com/studio/problems/first-repeated-character_1214646?leftPanelTabValue=PROBLEM


class Solution
{
    char firstRep(String S)
    {
        for(int i = 0; i < S.length() - 1; i++){
            for(int j = i + 1; j < S.length(); j++){
                if(S.charAt(i) == S.charAt(j)){
                    return S.charAt(i);
                }
            }
        }
        
        return '#';
    }
}