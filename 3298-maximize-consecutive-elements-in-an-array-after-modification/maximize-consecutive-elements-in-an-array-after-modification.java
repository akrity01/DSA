
import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int answer = 0;

        for (int num : nums) {

            // Previous DP value before updating
            int old = dp.getOrDefault(num, 0);

            // Choice 1: Keep num unchanged
            int keep = dp.getOrDefault(num - 1, 0) + 1;

            // Choice 2: Increase num by 1
            int increase = old + 1;

            // Update both possible ending values
            dp.put(num, Math.max(
                old, keep
            ));

            dp.put(num + 1, Math.max(
                dp.getOrDefault(num + 1, 0),
                increase
            ));

            answer = Math.max(
                answer,
                Math.max(dp.get(num), dp.get(num + 1))
            );
        }

        return answer;
    }
}
