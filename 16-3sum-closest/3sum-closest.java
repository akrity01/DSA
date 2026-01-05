
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;

        // Initialize with first 3 elements
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int currSum = nums[i] + nums[left] + nums[right];

                // If this is closer to target, update
                if (Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currSum;
                }

                // If exact match found, return immediately
                if (currSum == target) {
                    return currSum;
                }
                else if (currSum < target) {
                    left++;   // increase sum
                }
                else {
                    right--;  // decrease sum
                }
            }
        }

        return closestSum;
    }
}
