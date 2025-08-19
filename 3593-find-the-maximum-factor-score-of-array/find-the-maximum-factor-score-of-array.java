class Solution {
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper: LCM
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }

    public long maxScore(int[] nums) {
         int n = nums.length;

        // Edge case: single element
        if (n == 1) {
            long val = nums[0];
            return val * val;
        }

        long[] prefixGCD = new long[n];
        long[] suffixGCD = new long[n];
        long[] prefixLCM = new long[n];
        long[] suffixLCM = new long[n];

        // Prefix GCD & LCM
        prefixGCD[0] = nums[0];
        prefixLCM[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixGCD[i] = gcd(prefixGCD[i - 1], nums[i]);
            prefixLCM[i] = lcm(prefixLCM[i - 1], nums[i]);
        }

        // Suffix GCD & LCM
        suffixGCD[n - 1] = nums[n - 1];
        suffixLCM[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixGCD[i] = gcd(suffixGCD[i + 1], nums[i]);
            suffixLCM[i] = lcm(suffixLCM[i + 1], nums[i]);
        }

        long maxScore = 0;

        // Case 1: No removal
        maxScore = Math.max(maxScore, prefixGCD[n - 1] * prefixLCM[n - 1]);

        // Case 2: Remove one element
        for (int i = 0; i < n; i++) {
            long g, l;

            if (i == 0) { // remove first
                g = suffixGCD[1];
                l = suffixLCM[1];
            } else if (i == n - 1) { // remove last
                g = prefixGCD[n - 2];
                l = prefixLCM[n - 2];
            } else {
                g = gcd(prefixGCD[i - 1], suffixGCD[i + 1]);
                l = lcm(prefixLCM[i - 1], suffixLCM[i + 1]);
            }

            maxScore = Math.max(maxScore, g * l);
        }

        return maxScore;
    }
}
