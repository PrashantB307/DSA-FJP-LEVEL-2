
//  https://leetcode.com/problems/power-of-two/description/

//  https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1


import java.util.*;

public class Main71 {

    public static boolean ispower2(int n){
        return n > 0 && (n & (n - 1)) == 0;

    }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here

    System.out.println(ispower2(n));

    scn.close();
    
  }

}