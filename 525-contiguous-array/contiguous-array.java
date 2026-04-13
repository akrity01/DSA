import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLen = 0;
        
        // Important: sum 0 at index -1 (handles edge cases)
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 → -1, 1 → +1
            if (nums[i] == 0) {
                prefixSum -= 1;
            } else {
                prefixSum += 1;
            }

            // If this sum seen before → subarray with sum 0 exists
            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, length);
            } else {
                // Store first occurrence only
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}