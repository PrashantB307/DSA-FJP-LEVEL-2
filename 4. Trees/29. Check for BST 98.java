

//  https://leetcode.com/problems/validate-binary-search-tree/

//  https://practice.geeksforgeeks.org/problems/check-for-bst/1


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    boolean isBSt = true;
    public boolean isValidBST(TreeNode root) {
        
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

        return isBSt;
    }

    public void helper(TreeNode root, long min, long max){

        if(root == null){
            return;
        }

        if(root.val <= min || root.val >= max){
            isBSt = false;
        }

        if(root.left != null){
            helper(root.left, min, root.val);
        }

        if(root.right != null){
            helper(root.right, root.val, max);
        }
        
    }
}