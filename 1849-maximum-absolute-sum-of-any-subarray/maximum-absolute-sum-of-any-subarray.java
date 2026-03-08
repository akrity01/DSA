class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int maxsum = 0;
        int minsum = 0;
        int res = 0;

        for(int num : nums){
            maxsum = Math.max(num, maxsum + num);
            minsum = Math.min(num, minsum + num);

            res = Math.max(res,
                    Math.max(Math.abs(maxsum), Math.abs(minsum)));
        }

        return res;
    }
}