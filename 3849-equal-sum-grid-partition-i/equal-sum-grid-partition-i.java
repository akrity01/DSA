class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long totalSum = 0;

        // Step 1: Calculate total sum
        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }

        // If total sum is odd, can't divide equally
        if (totalSum % 2 != 0) return false;

        long target = totalSum / 2;

        // Step 2: Check horizontal cuts
        long rowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == target) return true;
        }

        // Step 3: Check vertical cuts
        long colSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            if (colSum == target) return true;
        }

        return false;
    }
}