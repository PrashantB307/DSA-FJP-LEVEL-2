

//  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

//  https://practice.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1



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
    TreeNode pre = null;
    public void flatten(TreeNode node) {
        if(node == null){
            return ;
        }

        flatten(node.right);
        flatten(node.left);

        node.right = pre;
        node.left = null;
        pre = node;
    }

}



//  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX



class Solution2 {
    class Pair {
        TreeNode head;
        TreeNode tail;

        Pair(){

        }

        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }

    public void flatten(TreeNode root) {
        if(root != null){
            helper(root);
        }
    }

    public Pair helper(TreeNode node){

        if(node.left != null && node.right != null){
            Pair lp = helper(node.left);
            Pair rp = helper(node.right);

            Pair mp = new Pair();

            mp.head = node;
            mp.head.left = null;
            mp.head.right = lp.head;
            lp.tail.right = rp.head;
            mp.tail = rp.tail;

            return mp;
        }else if(node.left != null){
            Pair lp = helper(node.left);

            Pair mp = new Pair();

            mp.head = node;
            mp.head.left = null;
            mp.head.right = lp.head;
            mp.tail = lp.tail;

            return mp;
        }else if(node.right != null){
            Pair rp = helper(node.right);

            Pair mp = new Pair();

            mp.head = node;
            mp.head.left = null;
            mp.head.right = rp.head;
            mp.tail = rp.tail;

            return mp;
        }else{
            Pair mp = new Pair(node, node);

            return mp;
        }
    }
}