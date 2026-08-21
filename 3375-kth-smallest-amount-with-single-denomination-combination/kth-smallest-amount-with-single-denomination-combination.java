import java.util.*;

class Solution {
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long count(long x, int[] c) {
        long ans = 0;
        int n = c.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    long g = gcd(lcm, c[i]);
                    lcm = lcm / g * c[i];
                    if (lcm > x) break;
                }
            }

            if (lcm <= x)
                ans += (bits % 2 == 1 ? 1 : -1) * (x / lcm);
        }
        return ans;
    }

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);

        long lo = 1, hi = (long) coins[0] * k;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (count(mid, coins) >= k)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }
}