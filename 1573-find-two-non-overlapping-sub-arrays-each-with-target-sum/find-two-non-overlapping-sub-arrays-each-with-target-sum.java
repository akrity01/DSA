
class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Shrink window if sum exceeds target
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            // If current window sum equals target
            if (sum == target) {

                int currentLength = right - left + 1;

                // Check for a previous non-overlapping subarray
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {

                    minLength = Math.min(
                        minLength,
                        currentLength + dp[left - 1]
                    );
                }

                // Store minimum subarray length ending at or before right
                if (right == 0) {
                    dp[right] = currentLength;
                } else {
                    dp[right] = Math.min(dp[right - 1], currentLength);
                }

            } else {

                // Carry forward previous minimum
                if (right > 0) {
                    dp[right] = dp[right - 1];
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}