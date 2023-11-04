

//     https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1


class Node
{
	int data, height;
	Node left, right;
	Node(int x)
	{
		data = x;
		height = 1;
		left = right = null;
	}
}
class Solution
{
    Node head;
    Node prev;
    
    Node bToDLL(Node root)
    {
        if(root == null){
            return null;
        }
        
        head = null;
        prev = null;
        
        inorder(root);
        
        return head;
    }
    
    void inorder(Node node){
        
        if(node == null){
            return;
        }
        
        inorder(node.left);
        
        if(prev == null){
            head = node;
        }else{
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        
        inorder(node.right);
    }
}