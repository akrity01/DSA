
import java.util.*;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        long[] prefix = new long[n + 1];

        // Step 1: Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        // Step 2: Maintain prefix sums in a TreeMap
        TreeMap<Long, Integer> map = new TreeMap<>();

        long ans = Long.MAX_VALUE;

        // Step 3: Iterate over possible ending indices
        for (int i = l; i <= n; i++) {

            // Add the prefix sum corresponding to length l
            int addIndex = i - l;
            map.put(prefix[addIndex],
                    map.getOrDefault(prefix[addIndex], 0) + 1);

            // Remove prefix sums that exceed maximum length r
            int removeIndex = i - r - 1;

            if (removeIndex >= 0) {
                long value = prefix[removeIndex];

                int count = map.get(value);

                if (count == 1) {
                    map.remove(value);
                } else {
                    map.put(value, count - 1);
                }
            }

            // Step 4: Find the largest prefix sum smaller than prefix[i]
            Long previous = map.lowerKey(prefix[i]);

            if (previous != null) {
                long sum = prefix[i] - previous;
                ans = Math.min(ans, sum);
            }
        }

        // Step 5: Return the minimum positive sum
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
