

//  https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/



import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        ArrayList<TreeNode> l1 = getPath(root, startValue);
        ArrayList<TreeNode> l2 = getPath(root, destValue);

        int i = l1.size() - 1;
        int j = l2.size() - 1;

        while(i >= 0 && j >= 0){
            if(l1.get(i) == l2.get(j)){
                i--;
                j--;
            }else{
                break;
            }
        }

        i++;
        j++;

        StringBuilder str = new StringBuilder();

        for(int ii = 0; ii < i; ii++){
            str.append("U");
        }

        for(int jj = j; jj > 0; jj--){
            if(l2.get(jj - 1) == l2.get(jj).left){
                str.append("L");
            }else{
                str.append("R");
            }
        }

        return str.toString();

    }

    public ArrayList<TreeNode> getPath(TreeNode node, int val) {

        if (node == null) {
            return new ArrayList<>();
        }

        if (node.val == val) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        } else {
            ArrayList<TreeNode> left = getPath(node.left, val);
            if (left.size() > 0) {
                left.add(node);
                return left;
            } else {
                ArrayList<TreeNode> right = getPath(node.right, val);
                if (right.size() > 0) {
                    right.add(node);
                    return right;
                }else{
                    return new ArrayList<>();
                }
            }
        }
    }
}