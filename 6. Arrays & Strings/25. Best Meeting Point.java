


//     https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/best-meeting-point/ojquestion


import java.util.*;
class Main25 {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
        
        ArrayList<Integer> rows = new ArrayList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                }
            }
        }

        ArrayList<Integer> cols = new ArrayList<>();
        
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 1){
                    cols.add(i);
                }
            }
        }

        int r = rows.get(rows.size() / 2);
        int c = cols.get(cols.size() / 2);

        int d1 = 0;
        for(int row : rows){
            d1 += Math.abs(r - row);
        }

        int d2 = 0;
        for(int col : cols){
            d2 += Math.abs(c - col);
        }

        return d1 + d2;

    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);

        scn.close();
    }
}