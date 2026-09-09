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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currentNumber) {

        // Empty node
        if (root == null) {
            return 0;
        }

        // Build the number
        currentNumber = currentNumber * 10 + root.val;

        // If leaf, return the number formed
        if (root.left == null && root.right == null) {
            return currentNumber;
        }

        // Sum of numbers from left and right subtrees
        return dfs(root.left, currentNumber)
             + dfs(root.right, currentNumber);
    }
}