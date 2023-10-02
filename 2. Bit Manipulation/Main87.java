

//  https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1


import java.util.*;

public class Main87 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));


    scn.close();
  }

  public static int solution(int n){
    
    if(n == 0){
        return 0;
    }

    int x = biggest2Kapower(n);
    int bitstill2x = x * (1 << (x - 1));
    int countofMSBfrom2xToN = n - (1 << x) + 1;
    int rob = solution(n - (1 << x)); 

    return bitstill2x + countofMSBfrom2xToN + rob;
  }

  public static int biggest2Kapower(int n){
    int x = 0;

    while((1 << x) <= n){
        x++;
    }

    return x - 1;
  }

}