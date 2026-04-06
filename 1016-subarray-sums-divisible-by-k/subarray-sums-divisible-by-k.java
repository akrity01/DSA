class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;  // base case

        int sum = 0, res = 0;

        for (int num : nums) {
            sum += num;

            int rem = sum % k;
            if (rem < 0) rem += k;

            res += count[rem]; // add previous occurrences

            count[rem]++; // update frequency
        }

        return res;
    }
}