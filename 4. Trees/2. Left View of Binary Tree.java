

//  https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1



import java.util.*;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ret = new ArrayList<>();
      
      if(root == null){
          return ret;
      }
      
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      
      while(q.size() > 0){
          int lsize = q.size();
          
          for(int i = 0; i < lsize; i++){
              Node temp = q.remove();
              
              if(i == 0){
                  ret.add(temp.data);
              }
              
              if(temp.left != null){
                  q.add(temp.left);
              }
              
              if(temp.right != null){
                  q.add(temp.right);
              }
          }
      }
      
      return ret;
      
      
    }
}