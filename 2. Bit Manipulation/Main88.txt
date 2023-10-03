import java.util.*;

public class Main88 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
   

    System.out.println(((n << 3) - n) >> 3);
    
    scn.close();
    
  }

}