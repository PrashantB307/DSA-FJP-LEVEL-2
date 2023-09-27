
//  https://leetcode.com/problems/number-of-1-bits/description/

//  https://practice.geeksforgeeks.org/problems/set-bits0143/1


import java.util.*;

public class MAin67 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here

    int count = 0;
    
       // rsb = right most set(1) bit
    while(n != 0){
        int rsb = n & -n;
        n = n - rsb;
        count++;
    } 

    System.out.println(count);

    scn.close();
  }

}
