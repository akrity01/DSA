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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        // 1. ROOT
        result.add(root.val);

        // 2. LEFT
        preorder(root.left, result);

        // 3. RIGHT
        preorder(root.right, result);
    }
}