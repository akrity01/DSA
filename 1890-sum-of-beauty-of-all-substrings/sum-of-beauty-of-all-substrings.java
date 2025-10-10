      class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

       for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;

              for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                freq[idx]++;
                maxFreq = Math.max(maxFreq, freq[idx]);

                  int minFreq = n;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) minFreq = Math.min(minFreq, freq[k]);
                }
                 ans += (maxFreq - minFreq);
            }
        }

        return ans;
    }
}
                


