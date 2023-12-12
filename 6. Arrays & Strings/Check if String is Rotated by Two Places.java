

//    https://www.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1


class Solution{

    public static boolean isRotated(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        String s1 = str1.substring(2) + str1.substring(0, 2);
        String s2 = str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2);

        if(s1.equals(str2) || s2.equals(str2)){
            return true;
        }

        return false;
    }
    
}