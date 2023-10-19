

//   https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/abbreviation-suing-backtracking-official/ojquestion



import java.util.*;
public class Main39 {

    public static void solution(String str, String asf,int count, int pos){
        
        if(pos == str.length()){
            if(count > 0){
                System.out.println(asf + count);
            }else{
                System.out.println(asf);
            }
            return;
        }
        
        if(count > 0){
            solution(str, asf + count + str.charAt(pos), 0, pos + 1);
        }else{
            solution(str, asf + str.charAt(pos), 0, pos + 1);
        }

        solution(str, asf, count + 1, pos + 1);
        
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);

        scn.close();
    }
    
    
}