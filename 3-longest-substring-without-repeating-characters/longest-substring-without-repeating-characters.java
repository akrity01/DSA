class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0 ; 
        int high;
        int n = s.length();
        int maxlen=0;
        int f[]= new int [256];
        for ( high =0;high<n;high++)
        {
           char ch =s.charAt(high);
           f[ch]++;
          while (f[ch]>1)
           {
            f[s.charAt(low)]--;
            low++;
           }
           maxlen= Math.max(maxlen,(high-low+1));
        }
        return maxlen;
    }
}