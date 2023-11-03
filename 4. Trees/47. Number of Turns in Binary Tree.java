

//   https://practice.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1


class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class Solution
{
    static int count;
    static int NumberOfTurns(Node root, int first, int second)
    {
        count = 0;
        Node lca = findLCA(root, first, second);

        boolean left = true;
        if(lca.data == first){
            findCount(lca.left, left, second);
            findCount(lca.right, !left, second);
        }else if(lca.data == second){
            findCount(lca.left, left, first);
            findCount(lca.right, !left, first);
        }else{
            findCount(lca.left, left, first);
            findCount(lca.right, !left, first);
            findCount(lca.left, left, second);
            findCount(lca.right, !left, second);

            return count + 1;
        }

        return count;
    }

    static boolean findCount(Node node, boolean left, int val){
        if(node == null){
            return false;
        }
        if(node.data == val){
            return true;
        }

        if(left){
            if(findCount(node.left, left, val)){
                return true;
            }
            if(findCount(node.right, !left, val)){
                count++;
                return true;
            }
        }else{
            if(findCount(node.right, left, val)){
                return true;
            }
            if(findCount(node.left, !left, val)){
                count++;
                return true;
            }
        }

        return false;
    }

    static Node findLCA(Node node, int f, int s){
        if(node == null){
            return null;
        }

        if(node.data == f || node.data == s){
            return node;
        }

        Node left = findLCA(node.left, f, s);
        Node right = findLCA(node.right, f, s);

        if(left != null && right != null){
            return node;
        }else {
            return left == null ? right : left;
        }
    }
}
