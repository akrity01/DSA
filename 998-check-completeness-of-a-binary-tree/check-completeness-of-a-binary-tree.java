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
    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean foundNull = false;

        while (!q.isEmpty()) {

            TreeNode current = q.poll();

            // We have already seen a null
            if (current == null) {
                foundNull = true;
            } 
            else {

                // If a null appeared before this node,
                // tree cannot be complete
                if (foundNull) {
                    return false;
                }

                q.offer(current.left);
                q.offer(current.right);
            }
        }

        return true;
    }
}