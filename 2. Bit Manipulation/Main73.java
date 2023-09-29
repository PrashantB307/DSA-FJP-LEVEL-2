
import java.util.*;

public class Main73 {

    public static int solution(int[] arr){
      
        int xor = 0;
        for(int ele : arr){
            xor = xor ^ ele;
        }
       
       return 2 * xor;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));

        scn.close();
    }
    
    
}