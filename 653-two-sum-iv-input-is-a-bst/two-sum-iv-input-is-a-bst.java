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
import java.util.HashSet;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();

        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, HashSet<Integer> set) {

        // Base case
        if (node == null) {
            return false;
        }

        // Check if complement exists
        if (set.contains(k - node.val)) {
            return true;
        }

        // Store current value
        set.add(node.val);

        // Search left and right
        return dfs(node.left, k, set) ||
               dfs(node.right, k, set);
    }
}