

//   https://leetcode.com/problems/binary-tree-preorder-traversal/


import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    static void solve(TreeNode root, List<Integer> ans){
        
        if(root == null){
            return ;
        }

        ans.add(root.val);
        solve(root.left, ans);
        solve(root.right, ans);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        solve(root, ans);

        return ans;
        
    }
}