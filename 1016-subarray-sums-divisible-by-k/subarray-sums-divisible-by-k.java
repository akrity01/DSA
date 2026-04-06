import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: remainder 0 appears once
        map.put(0, 1);
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            int remainder = prefixSum % k;
            
            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }
            
            // If remainder seen before, add its frequency
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            
            // Update frequency
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}