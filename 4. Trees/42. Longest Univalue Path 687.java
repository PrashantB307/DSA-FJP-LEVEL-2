

//  https://leetcode.com/problems/longest-univalue-path/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    int len;
    public int longestUnivaluePath(TreeNode root) {
        len = 0;
        helper(root, -1);

        if(len > 0){
            len = len - 1;
        }

        return len;
    }

    public int helper(TreeNode node, int val){

        if(node == null){
            return 0;
        }

        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);

        if(left + right + 1 > len){
            len = left + right + 1;
        }

        if(val == node.val){
            return Math.max(left, right) + 1;
        }else{
            return 0;
        }
    }
}
