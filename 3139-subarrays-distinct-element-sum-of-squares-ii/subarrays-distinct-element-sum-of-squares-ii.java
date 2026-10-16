import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    int n;
    long[] sum, sq, lazy;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long ans = 0;

        for (int r = 0; r < n; r++) {
            int prev = lastSeen.getOrDefault(nums[r], -1);

            update(1, 0, n - 1, prev + 1, r);

            lastSeen.put(nums[r], r);

            ans = (ans + sq[1]) % MOD;
        }

        return (int) ans;
    }

    void apply(int node, int left, int right, long val) {
        long len = right - left + 1L;

        sq[node] = (sq[node] + 2L * val * sum[node]
                    + val * val % MOD * len) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void pushDown(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int left, int right, int ql, int qr) {
        if (right < ql || left > qr) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        pushDown(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}