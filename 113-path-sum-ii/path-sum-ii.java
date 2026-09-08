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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode root, int targetSum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        // Empty node
        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.val);

        // Check if current node is a leaf
        if (root.left == null && root.right == null) {

            // Check whether path sum equals target
            if (targetSum == root.val) {
                result.add(new ArrayList<>(path));
            }

            // Backtrack
            path.remove(path.size() - 1);
            return;
        }

        // Remaining sum
        int remainingSum = targetSum - root.val;

        // Search left and right
        dfs(root.left, remainingSum, path, result);
        dfs(root.right, remainingSum, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}