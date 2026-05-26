class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        else {

            // no left child
            if (root.left == null)
                return root.right;

            // no right child
            if (root.right == null)
                return root.left;

            // find smallest in right subtree
            TreeNode curr = root.right;

            while (curr.left != null) {
                curr = curr.left;
            }

            // replace value
            root.val = curr.val;

            // delete successor
            root.right = deleteNode(root.right, curr.val);
        }

        return root;
    }
}