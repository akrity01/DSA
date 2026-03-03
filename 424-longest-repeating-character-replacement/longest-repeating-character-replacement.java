class Solution {
    public int find(int [] freq){
        int maxi= - 1;
        for ( int i = 0 ; i<256; i++)
        {
            maxi= Math.max(maxi, freq[i]);
        }
        return maxi;
    } 
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int f[]= new int[256];
        int low=0;
        int high=0;
        int res= Integer.MIN_VALUE;
        for ( high=0 ; high< n ; high++)
        {
            f[s.charAt(high)]++;
            int len = high- low +1;
            int maxc= find(f);
            int diff= len-maxc; 

            while(diff>k)
            {
                f[s.charAt(low)]--;
                low++;
                len = high- low +1;
                maxc= find(f);
                diff= len-maxc; 
            }
        len= high- low +1 ;
        res= Math.max(res, len);
        }
    return res;
    }
}