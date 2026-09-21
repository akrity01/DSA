class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        long[] dp = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            int rem = num % k;

            // Start a new subarray
            next[rem]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {

                    int newRem = (int) ((long) r * rem % k);

                    next[newRem] += dp[r];
                }
            }

            // Update DP and result
            for (int r = 0; r < k; r++) {

                dp[r] = next[r];

                result[r] += next[r];
            }
        }

        return result;
    }
}