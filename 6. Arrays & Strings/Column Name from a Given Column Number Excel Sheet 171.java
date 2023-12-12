
//     https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1


class Solution
{
    String colName (long n)
    {
        String ans = "";
        while(n > 0){
            char ch = (char)('A' + ( n - 1) % 26);
            ans = ch + ans;
            n = (n - 1) / 26;
        }
        
        return ans;
    }
}


// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx

// L-171 Excel Sheet Column Number

//   https://leetcode.com/problems/excel-sheet-column-number/description/

class Solution2 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(int i = 0; i < columnTitle.length(); i++){
            res *= 26;
            res += columnTitle.charAt(i) - 'A' + 1;
        }

        return res;
    }
}