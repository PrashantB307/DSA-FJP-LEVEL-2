

//   https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1


class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}
class Solution {
  public Tree cloneTree(Tree tree) {
   
    createDuplicate(tree);
    setRandom(tree);
    Tree dup = removeDupli(tree);

    return dup;
  }

  public void createDuplicate(Tree node) {

    if (node == null) {
      return;
    }

    createDuplicate(node.left);
    createDuplicate(node.right);

    Tree duplicate = new Tree(node.data);
    duplicate.left = node.left;
    duplicate.right = null;
    node.left = duplicate;
  }

  public void setRandom(Tree orig){

    if(orig == null){
      return;
    }

    setRandom(orig.left.left);
    setRandom(orig.right);

    if(orig.random != null){
      orig.left.random = orig.random.left;
    }

  }

  public Tree removeDupli(Tree node){

    if(node == null){
      return null;
    }

    Tree leftDup = removeDupli(node.left.left);
    Tree rightDup = removeDupli(node.right);

    Tree dup = node.left;
    node.left = node.left.left;
    dup.left = leftDup;
    dup.right = rightDup;

    return dup;
  }

}