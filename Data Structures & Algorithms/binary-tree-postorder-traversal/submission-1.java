/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer>res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res=new ArrayList<>();
        postorder(root);
        return res;

    }
    public void postorder(TreeNode node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        res.add(node.val);
    }
}