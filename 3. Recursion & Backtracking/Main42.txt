


//    https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1



class Sol {
    
    static String max;
    public static String findMaximumNum(String str, int k) {
        
        max = str;
        
        solve(str, k, 0, str.length());
        
        return max;
    }
    
    public static void solve(String str, int k, int i, int n){
        
        if(str.compareTo(max) > 0){
            max = str;
        }
        
        if (k == 0) {
            return;
        }

        for (int ii = i; ii < str.length() - 1; ii++) {
            for (int j = ii + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(ii)) {
                    String swapped = swap(str, ii, j);
                    solve(swapped, k - 1, ii + 1, n);
                }
            }
        }
    }
 
    public static String swap(String str, int i, int j){
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1);

        return left + jth + middle + ith + right;
    }
}