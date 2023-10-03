

//  https://practice.geeksforgeeks.org/problems/sum-of-bit-differences2937/1


import java.util.*;

public class Main89 {

  public static long solution(int[] arr){
   
    int n  = arr.length;
    long ans = 0;
    for(int i = 0; i < 32; i++){
        long count = 0;
        for(int j = 0; j < n; j++){
            if((arr[j] & (1 << i)) == 0){
                count++;
            }
        }
        ans += (count * (n - count) * 2);
    } 
    return ans;
  }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));


    scn.close();
  }

}