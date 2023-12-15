

//   https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1


class Solution{
    static String longestPalin(String s){
        int n = s.length();
        if(s.length() <= 1){
            return s;
        }

        int maxLen = 1;
        int st = 0;
        int end = 0;

        for(int i = 0; i < n - 1; i++){
            int l = i, r = i;;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }else{
                    break;
                }
            }

            int len = r - l - 1;
            if(len > maxLen){
                maxLen = len;
                st = l + 1;
                end = r - 1;
            }
        }

        for(int i = 0; i < n - 1; i++){
            int l = i, r = i + 1;;
            while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }else{
                    break;
                }
            }

            int len = r - l - 1;
            if(len > maxLen){
                maxLen = len;
                st = l + 1;
                end = r - 1;
            }
        }

        return s.substring(st, end + 1);
    }
}