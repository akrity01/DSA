class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        
        // Fill with large number (infinity substitute)
        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0; // base case
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == max ? -1 : dp[amount];
    }
}

    
