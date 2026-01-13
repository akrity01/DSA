class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int[] need = new int[128];   // ASCII characters
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int required = t.length();

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (need[c] > 0) {
                required--;
            }
            need[c]--;

            // Window valid when required == 0
            while (required == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                need[leftChar]++;

                if (need[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
