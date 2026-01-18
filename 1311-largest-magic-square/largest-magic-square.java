class Solution {
    public int largestMagicSquare(int[][] g) {
        int m = g.length, n = g[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] d1  = new int[m + 1][n + 1];   // main diag
        int[][] d2  = new int[m + 1][n + 1];   // anti diag

        // Build all prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j+1] = row[i][j] + g[i][j];
                col[i+1][j] = col[i][j] + g[i][j];

                d1[i+1][j+1] = d1[i][j] + g[i][j];
                d2[i+1][j]   = d2[i][j+1] + g[i][j];
            }
        }

        int ans = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = ans + 1; i+k <= m && j+k <= n; k++) {

                    int target = row[i][j+k] - row[i][j];

                    boolean ok = true;

                    // Check all rows
                    for (int r = 0; r < k; r++) {
                        int sum = row[i+r][j+k] - row[i+r][j];
                        if (sum != target) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;

                    // Check all columns
                    for (int c = 0; c < k; c++) {
                        int sum = col[i+k][j+c] - col[i][j+c];
                        if (sum != target) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;

                    // Diagonal 1
                    int sum1 = d1[i+k][j+k] - d1[i][j];
                    if (sum1 != target) continue;

                    // Diagonal 2
                    int sum2 = d2[i+k][j] - d2[i][j+k];
                    if (sum2 != target) continue;

                    ans = k;
                }
            }
        }

        return ans;
    }
}
