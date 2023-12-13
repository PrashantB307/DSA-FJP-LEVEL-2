

//   https://leetcode.com/problems/decode-string/description/


class Solution {

    int i = 0;
    public String decodeString(String s) {
        
        StringBuilder sb = new StringBuilder();

        while (i < s.length() && s.charAt(i) != ']') {
            if(Character.isDigit(s.charAt(i))){
                int k = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    k = k * 10 + s.charAt(i++) - '0';
                }

                i++;

                String str = decodeString(s);
                while(k-- > 0){
                    sb.append(str);
                }

                i++;
            }else{
                sb.append(s.charAt(i++));
            }
        }

        return sb.toString();
    }
}
