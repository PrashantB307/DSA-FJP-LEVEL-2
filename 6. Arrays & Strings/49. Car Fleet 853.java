

//     https://leetcode.com/problems/car-fleet/


import java.util.*;
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < position.length; i++){
            map.put(position[i], speed[i]);
        }

        int groups = 0;
        double time = 0;

        for(Map.Entry<Integer, Integer> car : map.entrySet()){
            int pos = car.getKey();    //  pos = Position
            int spd = car.getValue();  //  spd = Speed

            int dist = target - pos;
            double ctime = dist * 1.0 / spd;

            if(ctime > time){
                time = ctime;
                groups++;
            }
        }

        return groups;
    }
}
