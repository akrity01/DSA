
import java.util.*;

class Solution {

    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Find minimum price and maximum factor
        int minPrice = Integer.MAX_VALUE;

        int[] freq = new int[n + 1];

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            minPrice = Math.min(minPrice, price);

            freq[factor]++;
        }

        // Step 2: Count items having factors divisible
        // by each factor using multiples
        int[] divisibleCount = new int[n + 1];

        for (int factor = 1; factor <= n; factor++) {

            int count = 0;

            for (int multiple = factor;
                 multiple <= n;
                 multiple += factor) {

                count += freq[multiple];
            }

            divisibleCount[factor] = count;
        }

        // Step 3: Sort item indices by price
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) ->
            Integer.compare(items[a][1], items[b][1])
        );

        // Step 4: Buy enhanced copies greedily
        long answer = 0;
        long remainingBudget = budget;

        for (int idx : order) {

            int factor = items[idx][0];
            int price = items[idx][1];

            // Count eligible items, excluding itself
            int freeCount = divisibleCount[factor] - 1;

            // Enhanced copies are not beneficial
            // when their price is >= 2 * minPrice
            if (price >= 2L * minPrice) {
                break;
            }

            if (freeCount == 0) {
                continue;
            }

            // How many enhanced copies can we purchase?
            long affordable = remainingBudget / price;

            long take = Math.min(
                (long) freeCount,
                affordable
            );

            // Each enhanced copy gives 2 total copies
            answer += 2L * take;

            remainingBudget -= take * price;

            // Cannot afford another copy at this price.
            // All subsequent prices are equal or higher.
            if (take < freeCount) {
                break;
            }
        }

        // Step 5: Spend remaining budget on cheapest items
        answer += remainingBudget / minPrice;

        return (int) answer;
    }
}
