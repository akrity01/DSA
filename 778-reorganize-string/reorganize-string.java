import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        // Step 1: Count frequency
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        // Insert only characters with frequency > 0
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder ans = new StringBuilder();

        int[] prev = null;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int index = curr[0];
            int count = curr[1];

            // Append character
            ans.append((char)(index + 'a'));

            count--;

            // Push previous back if it still has remaining frequency
            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            // Store current as previous
            prev = new int[]{index, count};
        }

        // If one character is still left, answer is impossible
        if (prev != null && prev[1] > 0) {
            return "";
        }

        return ans.toString();
    }
}