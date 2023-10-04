

//     https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-30654/1


class Sol {
    int isDivisible(String str) {
        int odd = 0;
        int even = 0;

        for(int i = 0; i < str.length(); i++){
            int bit = str.charAt(i) - '0';
            if(i % 2 == 0){
                even += bit;
            }else{
                odd += bit;
            }
        }
        
        int delta = even - odd;
        if(delta % 3 == 0){
            return 1;
        }else{
            return 0;
        }
    }
}