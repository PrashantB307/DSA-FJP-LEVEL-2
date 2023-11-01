

//   https://leetcode.com/problems/distribute-coins-in-binary-tree/



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

    class Pair {
        int nodes;
        int coins;
    }

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        
        helper(root);
        return moves;
    }

    public Pair helper(TreeNode root){
        if (root == null){
            return new Pair();
        }

        Pair lp = helper(root.left);
        Pair rp = helper(root.right);

        Pair mp = new Pair();
        mp.nodes = lp.nodes + rp.nodes + 1;
        mp.coins = lp.coins + rp.coins + root.val;

        moves += Math.abs(mp.nodes - mp.coins);

        return mp;
    }
}