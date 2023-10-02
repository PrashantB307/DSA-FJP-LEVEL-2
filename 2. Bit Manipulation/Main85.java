import java.util.*;

public class Main85 {

  public static void solution(boolean[][] board, int qpsf, int cols, int ndiag, int rdiag, String asf) {
    // write your code here

    if(qpsf == board.length){
        System.out.println(asf + ".");
        return;
    }

    for (int i = 0; i < board.length; i++) {
        if((cols & (1 << i)) == 0 && (ndiag & (1 << (qpsf + i))) == 0 && (rdiag & (1 << (qpsf - i + board.length - 1))) == 0){
            
            board[qpsf][i] = true;
            cols ^= (1 << i);
            ndiag ^= (1 << (qpsf + i)); 
            rdiag ^= (1 << (qpsf - i + board.length - 1)); 

            solution(board,  qpsf + 1, cols, ndiag, rdiag, asf + qpsf + "-" + i + ",");

            board[qpsf][i] = false;
            cols ^= (1 << i);
            ndiag ^= (1 << (qpsf + i)); 
            rdiag ^= (1 << (qpsf - i + board.length - 1)); 
        }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");


    scn.close();
  }

}