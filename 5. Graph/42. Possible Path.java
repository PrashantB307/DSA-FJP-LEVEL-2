


//    https://practice.geeksforgeeks.org/problems/castle-run3644/1%20=%20ecircuit


class Solution
{
    public int isPossible(int[][] paths)
    {
       int count = 0;

        for(int i = 0; i < paths.length; i++){
            int size = 0;
            for(int j = 0; j < paths.length; j++){
                if(i != j && paths[i][j] == 1){
                    size++;
                }
            }

            if(size % 2 == 1){
                count++;
            }
        }

        if(count == 0){
            return 1;
        }

        return 0;
    }
}