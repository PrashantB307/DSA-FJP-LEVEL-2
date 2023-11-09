


//    https://leetcode.com/problems/surrounded-regions/description/

//    https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1



class Solution {

    public void solve(char[][] board) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != 'K'){
                    board[i][j] = 'X';
                }else{
                    board[i][j] = 'O';
                }
            }
        }
    }

    static void dfs(char mat[][],int i,int j){
        
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 'O'){
            return ;
        }
        
        mat[i][j] = 'K';
        
        dfs(mat, i + 1, j);
        dfs(mat, i - 1, j);
        dfs(mat, i, j + 1);
        dfs(mat, i, j - 1);
    }
}