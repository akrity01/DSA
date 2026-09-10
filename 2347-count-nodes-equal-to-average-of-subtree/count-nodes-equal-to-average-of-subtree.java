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
    
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    // Returns {sum of subtree, number of nodes in subtree}
    private int[] dfs(TreeNode node) {
        
        // Empty subtree
        if (node == null) {
            return new int[]{0, 0};
        }

        // Get sum and count from left subtree
        int[] left = dfs(node.left);

        // Get sum and count from right subtree
        int[] right = dfs(node.right);

        // Calculate current subtree sum
        int sum = left[0] + right[0] + node.val;

        // Calculate current subtree node count
        int nodes = left[1] + right[1] + 1;

        // Calculate average using integer division
        int average = sum / nodes;

        // Check if current node equals subtree average
        if (node.val == average) {
            count++;
        }

        // Return sum and count to parent
        return new int[]{sum, nodes};
    }
}