

//   https://practice.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1

//   https://www.codingninjas.com/studio/problems/normal-bst-to-balanced-bst_920472



import java.util.*;
class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class GfG
{
    Node buildBalancedTree(Node root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        return createTree(0, list.size() - 1, list);
    }
    
    void inorder(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }
    
    Node createTree(int i, int j, ArrayList<Integer> list){
        if(i > j){
            return null;
        }
        
        int mid = (i + j) / 2;
        
        Node node = new Node(list.get(mid));
        node.left = createTree(i, mid - 1, list);
        node.right = createTree(mid + 1, j, list);
        
        return node;
    }
}