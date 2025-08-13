class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            ones = (ones ^ num) & ~twos; // add new bits to ones, remove if they are already in twos
            twos = (twos ^ num) & ~ones; // add new bits to twos, remove if they are already in ones
        }
        
        return ones; // ones will contain the unique number
    }
}
