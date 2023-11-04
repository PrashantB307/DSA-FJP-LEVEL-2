

//    https://practice.geeksforgeeks.org/problems/burning-tree/1

//    https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/


class Node
{
	int data, height;
	Node left, right;
	Node(int x)
	{
		data = x;
		height = 1;
		left = right = null;
	}
}
class Solution
{
    static int maxtime = 0;

    public static void burnTee(Node node, Node blocked, int time){

        if(node == null || node == blocked){
            return;
        }

        maxtime = Math.max(maxtime, time);

        burnTee(node.left, blocked, time + 1);
        burnTee(node.right, blocked, time + 1);
        
    }
    
    public static int burningTree(Node node, int tar){
        if(node == null){
            return -1;
        }

        if(node.data == tar){
            burnTee(node, null, 0);
            return 1;
        }

        int leftTime = burningTree(node.left, tar);
        if(leftTime != -1){
            burnTee(node, node.left, leftTime);
            return leftTime + 1;
        }

        int rightTime = burningTree(node.right, tar);
        if(rightTime != -1){
            burnTee(node, node.right, rightTime);
            return rightTime + 1;
        }

        return -1;
    } 

    public static int minTime(Node root, int target) 
    {
        maxtime = 0;
    
        burningTree(root, target);

        return maxtime;
    }
}