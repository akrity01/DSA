class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // -------- CASE 1: take houses from 0 to n-2 (exclude last) --------
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) { // only go up to n-2
            int skip = dp1[i - 1];
            int take = nums[i] + dp1[i - 2];
            dp1[i] = Math.max(skip, take);
        }
        int result1 = dp1[n - 2];

        // -------- CASE 2: take houses from 1 to n-1 (exclude first) --------
        int[] dp2 = new int[n];
        dp2[0] = 0;          // we skip first house
        dp2[1] = nums[1];    // start from second house
        for (int i = 2; i < n; i++) {
            int skip = dp2[i - 1];
            int take = nums[i] + dp2[i - 2];
            dp2[i] = Math.max(skip, take);
        }
        int result2 = dp2[n - 1];

        // -------- Answer is max of both cases --------
        return Math.max(result1, result2);
    }
}
