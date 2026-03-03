class Solution {
    
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int f[]= new int[26];
        int low=0;
        int high=0;
        int maxlen= 0;
        int maxfreq= 0 ;
        for ( high=0 ; high< n ; high++)
        {
            char ch = s.charAt(high);
            f[ch- 'A']++;
            maxfreq= Math.max(maxfreq, f[ch- 'A']);

            while((high-low+1)-maxfreq>k)
            {
                f[s.charAt(low)- 'A']--;
                low++;
            }
               maxlen= Math.max(maxlen,high-low+1);
        }
    return maxlen;
    }
}