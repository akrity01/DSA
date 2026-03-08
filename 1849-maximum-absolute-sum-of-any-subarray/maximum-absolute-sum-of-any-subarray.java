class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int res= Math.abs(nums[0]);
        int maxsum= nums[0];
        int minsum= nums[0];
        for (int i = 1;i< nums.length; i++)
        {
            int a = maxsum+nums[i];
            int b = minsum+nums[i];
            int c = nums[i];
             maxsum= Math.max(c,a);
             minsum= Math.min(c,b);
             res= Math.max(res,Math.max(Math.abs(minsum),Math.abs(maxsum)));
        }
        return res;
    }
}