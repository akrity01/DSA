class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];  // frequency of letters A-Z
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Track most frequent character in window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // If more than k replacements needed → shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
