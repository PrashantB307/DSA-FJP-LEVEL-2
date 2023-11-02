

//  https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1

//   https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

class Solution
{
    boolean f1 = false;
    boolean f2 = false;
	Node lca(Node root, int n1, int n2)
	{
		Node LCA = helper(root, n1, n2);

        if(f1 & f2){
            return LCA;
        }else{
            return null;
        }
	}

    Node helper(Node node, int n1, int n2){
        if(node == null){
            return null;
        }

        Node left = helper(node.left, n1, n2);
        Node right = helper(node.right, n1, n2);

        if(node.data == n1){
            f1 = true;
            return node;
        }else if(node.data == n2){
            f2 = true;
            return node;
        }else if(left != null && right != null){
            return node;
        }else if(left != null){
            return left;
        }else if(right != null){
            return right;
        }else{
            return null;
        }
    }
}