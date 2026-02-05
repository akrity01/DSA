import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);   // Step 1: sort
        long sum = 0;        // window sum (long to avoid overflow)
        int l = 0;
        int ans = 1;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];  // add current element to window sum

            // cost to make all elements in window equal to nums[r]
            while ((long) nums[r] * (r - l + 1) - sum > k) {
                sum -= nums[l];  // shrink window from left
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
