

//    https://leetcode.com/problems/maximum-frequency-stack/description/

//    https://www.codingninjas.com/studio/problems/maxfrequencystack_1262006



import java.util.*;
class FreqStack {

    HashMap<Integer, Integer> fmap;
    HashMap<Integer, Stack<Integer>> data;
    int mfreq;

    public FreqStack() {
       fmap = new HashMap<>();
       data = new HashMap<>();
       mfreq = 0;
    }
    
    public void push(int val) {
        int freq = fmap.getOrDefault(val, 0) + 1;
        fmap.put(val, freq);
        mfreq = Math.max(mfreq, freq);

        if(!data.containsKey(freq)){
            data.put(freq, new Stack<>());
        }

        data.get(freq).push(val);
    }
    
    public int pop() {
        int val = data.get(mfreq).pop();
        if(data.get(mfreq).size() == 0){
            mfreq--;
        }

        fmap.put(val, fmap.get(val) - 1);

        return val;
    }
}
