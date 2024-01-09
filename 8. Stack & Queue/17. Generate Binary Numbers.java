

//   https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1

//   https://www.codingninjas.com/studio/problems/generate-binary-numbers_981264


import java.util.*;
class solve{
    
    static ArrayList<String> generate(int N){

        ArrayList<String> res = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        list.add("1");

        int i = 1;
        while(i <= N){
            String rem = list.removeFirst();
            res.add(rem);

            list.add(rem + "0");
            list.add(rem + "1");

            i++;
        }

        return res;
        
    }
    
}
