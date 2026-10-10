
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int maxDiff = 0;
        long k = (long) k1 + k2;

        // 1. Find absolute differences and the maximum
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // 2. Count how often each difference occurs
        int[] freq = new int[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        // 3. Reduce the largest differences first
        for (int d = maxDiff; d > 0 && k > 0; d--) {

            int reduce = (int) Math.min(k, freq[d]);

            freq[d] -= reduce;
            freq[d - 1] += reduce;

            k -= reduce;
        }

        // 4. Calculate the final squared sum
        long answer = 0;

        for (int d = 0; d <= maxDiff; d++) {
            answer += (long) d * d * freq[d];
        }

        return answer;
    }
}
