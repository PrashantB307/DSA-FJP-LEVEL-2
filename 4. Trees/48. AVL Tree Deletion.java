

//  https://practice.geeksforgeeks.org/problems/avl-tree-deletion/1


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
class Sol {
    public static Node deleteNode(Node root, int data) {
        if (root == null)
            return root;
        if (root.data < data)
            root.right = deleteNode(root.right, data);
        else if (root.data > data)
            root.left = deleteNode(root.left, data);
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                int maximum = findMax(root.right);
                root.data = maximum;
                root.right = deleteNode(root.right, maximum);
            }
        }
        if (root == null)
            return root;
        int bff = bf(root);
        if (bff > 1 && bf(root.right) >= 0)
            return leftRotation(root);
        else if (bff < -1 && bf(root.left) <= 0)
            return rightRotation(root);
        else if (bff > 1 && bf(root.right) < 0) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        } else if (bff < -1 && bf(root.left) > 0) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        return root;
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int bf(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return rightHeight - leftHeight;
    }

    static Node leftRotation(Node x) {
        Node y = x.right;
        Node T = y.left;

        x.right = T;
        y.left = x;
        return y;
    }

    static Node rightRotation(Node x) {
        Node y = x.left;
        Node T = y.right;

        x.left = T;
        y.right = x;
        return y;
    }

    static int findMax(Node head) {
        if (head == null)
            return -1;
        while (head.left != null) {
            head = head.left;
        }
        return head.data;
    }
}