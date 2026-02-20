import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);  // Step 1: sort array
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // Step 2: skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Step 3: skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } 
                else if (currentSum < 0) {
                    left++;   // sum chhota hai, bada karne ke liye left++
                } 
                else {
                    right--;  // sum bada hai, kam karne ke liye right--
                }
            }
        }
        return result;
    }
}