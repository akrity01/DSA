class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int minsum = 0;
        int maxsum = 0;
        int totalsum = 0;

        int minGlobal = Integer.MAX_VALUE;
        int maxGlobal = Integer.MIN_VALUE;

        for (int n : nums) {

            totalsum += n;

            minsum = Math.min(n + minsum, n);
            minGlobal = Math.min(minGlobal, minsum);

            maxsum = Math.max(n + maxsum, n);
            maxGlobal = Math.max(maxGlobal, maxsum);
        }

        if (maxGlobal < 0) // edge case to reduce iteration in case of all the elements are negative
            return maxGlobal;

        int maxsum1 = totalsum - minGlobal;

        return Math.max(maxsum1, maxGlobal);
    }
}