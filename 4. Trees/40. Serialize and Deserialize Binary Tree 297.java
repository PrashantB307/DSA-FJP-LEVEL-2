

//   https://leetcode.com/problems/serialize-and-deserialize-binary-tree/



import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Codec {

    public String serialize(TreeNode root) {

        if(root == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        helper(root, sb);

        return sb.toString();
    }

    public void helper(TreeNode node, StringBuilder sb){

        if(node == null){
            sb.append(".");
            sb.append(" ");
            return;
        }

        sb.append(node.val);
        sb.append(" ");

        helper(node.left, sb);
        helper(node.right, sb);
    }

    class Pair {
        TreeNode node;
        int state = 0;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length() == 0){
            return null;
        }

        String [] darr = data.split(" ");

        Stack<Pair> st = new Stack<>();
        Pair rootp = new Pair();
        rootp.node = new TreeNode(Integer.parseInt(darr[0]));
        st.push(rootp);

        int idx = 0;

        while(st.size() > 0){
            Pair p = st.peek();

            if(p.state == 0){
                idx++;
                p.state++;

                if(darr[idx].equals(".") == false){
                    Pair leftp = new Pair();
                    leftp.node = new TreeNode(Integer.parseInt(darr[idx]));
                    p.node.left =  leftp.node;

                    st.push(leftp);
                }
            }else if(p.state == 1){
                idx++;
                p.state++;

                if(darr[idx].equals(".") == false){
                    Pair rightp = new Pair();
                    rightp.node = new TreeNode(Integer.parseInt(darr[idx]));
                    p.node.right =  rightp.node;

                    st.push(rightp);
                }
            }else{
                st.pop();
            }
        }

        return rootp.node;
    }
}


