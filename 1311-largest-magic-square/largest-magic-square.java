class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Prefix sums
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        int max = 1;   // at least 1

        // try every top-left corner
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // try sizes k
                for (int k = 2; i + k <= m && j + k <= n; k++) {

                    if (isMagic(grid, row, col, i, j, k)) {
                        max = Math.max(max, k);
                    }
                }
            }
        }

        return max;
    }

    private boolean isMagic(int[][] g, int[][] row, int[][] col,
                            int r, int c, int k) {

        // target = first row sum
        int target = row[r][c + k] - row[r][c];

        // check rows
        for (int i = 0; i < k; i++) {
            int sum = row[r + i][c + k] - row[r + i][c];
            if (sum != target) return false;
        }

        // check columns
        for (int j = 0; j < k; j++) {
            int sum = col[r + k][c + j] - col[r][c + j];
            if (sum != target) return false;
        }

        // main diagonal
        int d1 = 0;
        for (int i = 0; i < k; i++) {
            d1 += g[r + i][c + i];
        }
        if (d1 != target) return false;

        // anti diagonal
        int d2 = 0;
        for (int i = 0; i < k; i++) {
            d2 += g[r + i][c + k - 1 - i];
        }
        if (d2 != target) return false;

        return true;
    }
}
