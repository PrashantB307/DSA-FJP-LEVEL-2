

//     https://leetcode.com/problems/maximum-width-of-binary-tree/description/



import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {

    private long maxWidth = 1;

    private void DFS(TreeNode root, long d, int level, List<Long> arr) {
        if (root == null)
            return;

        if (level == arr.size()) {
            arr.add(d);
        } else {
            maxWidth = Math.max(maxWidth, d - arr.get(level) + 1);
        }

        DFS(root.left, 2 * d + 1, level + 1, arr);
        DFS(root.right, 2 * d + 2, level + 1, arr);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        maxWidth = 1;
        List<Long> arr = new ArrayList<>();
        DFS(root, 0, 0, arr);
        
        return (int) maxWidth;
    }
}
