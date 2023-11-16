class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // If the tree is empty, return null
        }

        // If the key is smaller than the root's key, then it lies in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If the key is larger than the root's key, then it lies in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.val = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }
}
