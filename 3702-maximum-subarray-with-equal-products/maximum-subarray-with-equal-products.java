
import java.util.*;

class Solution {

    public int maxLength(int[] nums) {
        int n = nums.length;

        // Special case: a single number is valid only if it is 1
        if (n == 1) {
            return nums[0] == 1 ? 1 : 0;
        }

        // Precompute distinct prime factors of every number
        List<Integer>[] factors = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            factors[i] = getPrimeFactors(nums[i]);
        }

        // Sliding window
        Set<Integer> used = new HashSet<>();

        int left = 0;
        int best = 0;

        for (int right = 0; right < n; right++) {

            // Shrink window while a prime factor is repeated
            while (hasConflict(used, factors[right])) {
                for (int prime : factors[left]) {
                    used.remove(prime);
                }
                left++;
            }

            // Add current number's prime factors
            for (int prime : factors[right]) {
                used.add(prime);
            }

            // Update longest pairwise-coprime window
            best = Math.max(best, right - left + 1);
        }

        // Any two-element subarray is always product equivalent
        return Math.max(2, best);
    }

    // Returns distinct prime factors of a positive integer
    private List<Integer> getPrimeFactors(int num) {
        List<Integer> result = new ArrayList<>();

        for (int p = 2; p <= num / p; p++) {
            if (num % p == 0) {
                result.add(p);

                while (num % p == 0) {
                    num /= p;
                }
            }
        }

        if (num > 1) {
            result.add(num);
        }

        return result;
    }

    // Checks whether any prime factor is already in the window
    private boolean hasConflict(Set<Integer> used,
                                List<Integer> currentFactors) {
        for (int prime : currentFactors) {
            if (used.contains(prime)) {
                return true;
            }
        }

        return false;
    }
}
