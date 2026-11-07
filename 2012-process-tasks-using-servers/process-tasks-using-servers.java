
import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy: [finishTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                if (a[1] != b[1]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[2], b[2]);
            }
        );

        // Initially all servers are free
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int j = 0; j < m; j++) {

            time = Math.max(time, j);

            // Free all servers completed by current time
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] curr = busy.poll();

                available.offer(new int[]{
                    (int) curr[1],
                    (int) curr[2]
                });
            }

            // If no server is available, jump to earliest finish
            if (available.isEmpty()) {

                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] curr = busy.poll();

                    available.offer(new int[]{
                        (int) curr[1],
                        (int) curr[2]
                    });
                }
            }

            // Select server with minimum weight and index
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[j] = index;

            // Mark server as busy
            busy.offer(new long[]{
                time + tasks[j],
                weight,
                index
            });
        }

        return ans;
    }
}
