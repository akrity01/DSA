class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }
        
        // Get rightmost set bit (differs between a and b)
        int diffBit = xorAll & (-xorAll);
        
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num; // group where bit is 0
            } else {
                b ^= num; // group where bit is 1
            }
        }
        
        return new int[]{a, b};
    }
}

    