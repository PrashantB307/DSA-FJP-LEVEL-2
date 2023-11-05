//   L-1305 .


//   https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1

//   https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/

//   https://www.codingninjas.com/studio/problems/elements-in-two-bsts_981278



import java.util.*;
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
class Solution
{

    public List<Integer> merge(Node root1,Node root2)
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        traverse(root1, list);
        traverse(root2, list);

        Collections.sort(list);
        return list;
    }
    
    public void traverse(Node node,  ArrayList<Integer> list){
        if(node == null){
            return;
        }
        
        traverse(node.left, list);
        list.add(node.data);
        traverse(node.right, list);
    }
}
