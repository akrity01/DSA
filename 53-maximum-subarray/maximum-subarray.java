class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int ans= nums[0];
        int n=nums.length;
        for (int i= 1; i< n ; i++)
        {
            int a= maxsum+nums[i];
            int b = nums[i];
           maxsum=Math.max(a,b);
         ans = Math.max(maxsum,ans);
        }
        
         return ans ;
    }
}