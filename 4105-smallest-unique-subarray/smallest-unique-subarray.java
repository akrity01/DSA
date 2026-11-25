
import java.util.*;

class Solution {

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        // Phase 1: Build the suffix array
        int[] sa = buildSuffixArray(nums);

        // Phase 2: Calculate LCP with the previous suffix
        int[] lcp = buildLCP(nums, sa);

        // Phase 3: Find the shortest unique subarray
        int answer = n;

        for (int i = 0; i < n; i++) {

            int prevLCP = lcp[i];

            int nextLCP = (i + 1 < n) ? lcp[i + 1] : 0;

            int longestCommon = Math.max(prevLCP, nextLCP);

            int requiredLength = longestCommon + 1;

            // Check whether the required subarray
            // fits within the remaining array
            int remainingLength = n - sa[i];

            if (requiredLength <= remainingLength) {
                answer = Math.min(answer, requiredLength);
            }
        }

        return answer;
    }

    // Builds suffix array using prefix doubling
    private int[] buildSuffixArray(int[] nums) {
        int n = nums.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Initial sorting based on the first element
        Arrays.sort(indices, (a, b) ->
            Integer.compare(nums[a], nums[b])
        );

        int[] rank = new int[n];
        int classes = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 &&
                nums[indices[i]] != nums[indices[i - 1]]) {
                classes++;
            }

            rank[indices[i]] = classes;
        }

        // Double the compared prefix length each round
        for (int len = 1; len < n; len *= 2) {

            final int[] currentRank = rank;
            final int currentLen = len;

            Arrays.sort(indices, (a, b) -> {

                if (currentRank[a] != currentRank[b]) {
                    return Integer.compare(
                        currentRank[a], currentRank[b]
                    );
                }

                int rankA = (a + currentLen < n)
                    ? currentRank[a + currentLen] : -1;

                int rankB = (b + currentLen < n)
                    ? currentRank[b + currentLen] : -1;

                return Integer.compare(rankA, rankB);
            });

            int[] newRank = new int[n];
            int newClasses = 0;

            for (int i = 1; i < n; i++) {

                int a = indices[i - 1];
                int b = indices[i];

                int aSecond = (a + len < n)
                    ? rank[a + len] : -1;

                int bSecond = (b + len < n)
                    ? rank[b + len] : -1;

                if (rank[a] != rank[b] ||
                    aSecond != bSecond) {
                    newClasses++;
                }

                newRank[b] = newClasses;
            }

            rank = newRank;

            if (newClasses == n - 1) {
                break;
            }

            if (len > n / 2) {
                break;
            }
        }

        int[] sa = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = indices[i];
        }

        return sa;
    }

    // Kasai's algorithm to build LCP array
    private int[] buildLCP(int[] nums, int[] sa) {
        int n = nums.length;

        int[] position = new int[n];

        for (int i = 0; i < n; i++) {
            position[sa[i]] = i;
        }

        int[] lcp = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {

            int rank = position[i];

            // No previous suffix exists
            if (rank == 0) {
                common = 0;
                continue;
            }

            int j = sa[rank - 1];

            while (i + common < n &&
                   j + common < n &&
                   nums[i + common] == nums[j + common]) {
                common++;
            }

            lcp[rank] = common;

            if (common > 0) {
                common--;
            }
        }

        return lcp;
    }
}
