

//   https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
 
//   https://www.codingninjas.com/studio/problems/print-common-elements_920540?leftPanelTab=0


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
class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        ArrayList<Integer> l2 = new ArrayList<>();
         HashMap<Integer,Integer> map = new HashMap<>();
        traverse1(root1, map);
        traverse2(root2, l2, map);
        
        return l2;
       
    }
    
    public static void traverse2(Node node, ArrayList<Integer> list, HashMap<Integer,Integer> map){
        if(node == null){
            return;
        }
    
        traverse2(node.left, list, map);
        if(map.containsKey(node.data)){
            list.add(node.data);
        }
        traverse2(node.right, list, map);
    } 
    
    public static void traverse1(Node node, HashMap<Integer,Integer> map){
        if(node == null){
            return;
        }
        
        traverse1(node.left, map);
        map.put(node.data, 1);
        traverse1(node.right, map);
    } 
}