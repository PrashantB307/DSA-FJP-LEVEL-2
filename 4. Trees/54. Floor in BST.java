

//   https://practice.geeksforgeeks.org/problems/floor-in-bst/1

//   https://www.codingninjas.com/studio/problems/floor-from-bst_920457


import java.util.*;
class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class Solution {
    
    public static int floor(Node root, int x) {
        
        List<Integer> list = new ArrayList<>();
        
        traverse(root, list);
        Collections.sort(list);
        
        if(list.get(0) > x){
            return -1;
        } 
        
        int len = list.size();
        
        for(int i = 0; i < len; i++){
            int n = list.get(i);
            if(n == x){
                return n;
            }else if(i > 0 && n > x){
                return list.get(i-1);
            } 
        }
        return list.get(len-1);
    }
    
    static void traverse(Node root,List<Integer> list){
        
        if(root == null){
            return;
        } 
         
        list.add(root.data);
        traverse(root.left, list);
        traverse(root.right, list);
    }
}