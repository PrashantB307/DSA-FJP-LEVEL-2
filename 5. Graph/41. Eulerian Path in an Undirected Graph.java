


//     https://practice.geeksforgeeks.org/problems/eulerian-path-in-an-undirected-graph5052/1
 

class Solution{
    static int eulerPath(int N, int graph[][]){
        
        int count = 0;

        for(int i = 0; i < graph.length; i++){
            int size = 0;
            for(int j = 0; j < graph.length; j++){
                if(i != j && graph[i][j] == 1){
                    size++;
                }
            }

            if(size % 2 == 0){
                count++;
            }
        }

        if(count == 0 || count == 2){
            return 1;
        }

        return 0;
    }
}
