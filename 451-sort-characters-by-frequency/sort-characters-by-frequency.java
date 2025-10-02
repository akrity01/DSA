class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) freq[c]++;

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            char maxChar = 0;
            for (char c = 0; c < 128; c++) {
                if (freq[c] > freq[maxChar]) maxChar = c;
            }
            while (freq[maxChar]-- > 0) sb.append(maxChar);
        }
        return sb.toString();
    }
}
