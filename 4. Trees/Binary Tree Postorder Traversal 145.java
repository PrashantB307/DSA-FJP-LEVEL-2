

//   https://leetcode.com/problems/binary-tree-postorder-traversal/description/


import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    ArrayList<Integer> list;
    public List<Integer> postorderTraversal(TreeNode root) {
        
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    void traverse(TreeNode node){
        if(node == null){
            return;
        }

        traverse(node.left);
        traverse(node.right);
        list.add(node.val);
    }
}