import java.util.*;

public class Main66 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int fcomp = ~n;    // first complement
    int scomp = fcomp + 1;  
    int rsb = (n & scomp); 
    System.out.println(Integer.toBinaryString(rsb));

    scn.close();
  }

}