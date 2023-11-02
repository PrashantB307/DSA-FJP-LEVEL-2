

//   https://leetcode.com/problems/kth-smallest-element-in-a-bst/

//   https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1


class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { data = x; }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {

        TreeNode curr = root;
        int count = 0;

        while (curr != null) {
            if (curr.left == null) {
                count++; 

                if(count == k){
                    return curr.data;
                }

                curr = curr.right;
            } else {
                TreeNode iop = curr.left;
                while (iop.right != null && iop.right != curr) {
                    iop = iop.right;
                }

                if (iop.right == null) {
                    iop.right = curr;
                    curr = curr.left;
                } else {
                    iop.right = null;

                    count++;
                    if(count == k){
                        return curr.data;
                    }
                    
                    curr = curr.right;
                }
            }
        }

        return -1;
    }
}