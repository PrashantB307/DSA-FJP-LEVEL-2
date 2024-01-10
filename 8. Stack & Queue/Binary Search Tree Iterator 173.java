

//   https://leetcode.com/problems/binary-search-tree-iterator/description/


import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class BSTIterator {

    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        push(temp.right);

        return temp.val;
    }
    
    public boolean hasNext() {
        if(st.size() == 0){
            return false;
        }else{
            return true;
        }
    }

    void push(TreeNode node){
        while (st.size() > 0) {
            st.push(node);
            node = node.left;
        }
    }
}