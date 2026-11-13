
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        long ans = 0;
        long cost = 0;

        int n = nums.length;
        int j = n - 1;

        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Maintain a non-increasing deque
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                int nextNum = last[0];
                int nextCount = last[1];

                count += nextCount;

                cost += (long) (num - nextNum) * nextCount;
            }

            dq.offerLast(new int[]{num, count});

            // Shrink the window if operations exceed k
            while (cost > k) {

                int[] first = dq.pollFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                cost -= (long) (rightmostNum - nums[j]);

                j--;

                if (rightmostCount > 1) {
                    dq.offerFirst(
                        new int[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }

            // Count valid subarrays ending at j
            ans += j - i + 1;
        }

        return ans;
    }
}
