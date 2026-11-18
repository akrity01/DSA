
import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1_000_000_000;

        // Part 1: Precompute the cost of every substring
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {

                int end = start + len - 1;
                int best = INF;

                // Try every proper divisor
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Build each group and make it a palindrome
                    for (int offset = 0; offset < d; offset++) {

                        int left = start + offset;

                        int right = left +
                            ((len - 1 - offset) / d) * d;

                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[start][end] = best;
            }
        }

        // Part 2: Partition DP
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {

            for (int end = 2 * parts; end <= n; end++) {

                for (int start = 2 * (parts - 1);
                     start <= end - 2;
                     start++) {

                    if (dp[parts - 1][start] == INF) {
                        continue;
                    }

                    int current = dp[parts - 1][start]
                                + cost[start][end - 1];

                    dp[parts][end] = Math.min(
                        dp[parts][end],
                        current
                    );
                }
            }
        }

        return dp[k][n];
    }
}
