
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    long lowSum = 0, highSum = 0;
    int lowSize = 0, highSize = 0;

    void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) map.remove(val);
        else map.put(val, count - 1);
    }

    void insert(int val) {
        if (low.isEmpty() || val <= low.lastKey()) {
            add(low, val);
            lowSum += val;
            lowSize++;
        } else {
            add(high, val);
            highSum += val;
            highSize++;
        }

        balance();
    }

    void erase(int val) {
        if (low.containsKey(val)) {
            remove(low, val);
            lowSum -= val;
            lowSize--;
        } else {
            remove(high, val);
            highSum -= val;
            highSize--;
        }

        balance();
    }

    void balance() {
        while (lowSize > highSize + 1) {
            int val = low.lastKey();

            remove(low, val);
            lowSum -= val;
            lowSize--;

            add(high, val);
            highSum += val;
            highSize++;
        }

        while (lowSize < highSize) {
            int val = high.firstKey();

            remove(high, val);
            highSum -= val;
            highSize--;

            add(low, val);
            lowSum += val;
            lowSize++;
        }
    }

    long getCost() {
        long median = low.lastKey();

        return median * lowSize - lowSum
             + highSum - median * highSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        if (k == 0) return 0;
        if ((long) x * k > n) return -1;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            insert(nums[i]);

            if (i >= x) {
                erase(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Select a window of size x
                if (i >= x && dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
