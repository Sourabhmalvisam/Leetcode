class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;

    }
}