class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            // If current number is negative, swap
            if (x < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(x, x * max);
            min = Math.min(x, x * min);

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
