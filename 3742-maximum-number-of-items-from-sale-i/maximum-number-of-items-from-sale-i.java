
class Solution {

    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Phase 1: Find the minimum item price
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }

        // Phase 2: Calculate the value of activating each item
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {

            int freeCount = 0;

            for (int j = 0; j < n; j++) {

                if (i != j &&
                    items[j][0] % items[i][0] == 0) {

                    freeCount++;
                }
            }

            // One purchased copy + free copies
            value[i] = 1 + freeCount;
        }

        // Phase 3: 0/1 Knapsack
        long[] dp = new long[budget + 1];

        for (int i = 0; i <= budget; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            int price = items[i][1];

            // Traverse backwards to use each item type once
            for (int cost = budget; cost >= price; cost--) {

                if (dp[cost - price] != -1) {

                    dp[cost] = Math.max(
                        dp[cost],
                        dp[cost - price] + value[i]
                    );
                }
            }
        }

        // Phase 4: Use remaining money to buy cheapest items
        long answer = 0;

        for (int cost = 0; cost <= budget; cost++) {

            if (dp[cost] == -1) {
                continue;
            }

            long remaining = budget - cost;

            long extraCopies = remaining / minPrice;

            long total = dp[cost] + extraCopies;

            answer = Math.max(answer, total);
        }

        return (int) answer;
    }
}
