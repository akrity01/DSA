import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // Initially, all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // {finishTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            // 1. Release servers whose requests are completed
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] completed = busy.poll();
                available.add(completed[1]);
            }

            // 2. If all servers are busy, drop request
            if (available.isEmpty()) {
                continue;
            }

            // 3. Find the preferred server
            int preferred = i % k;

            Integer server = available.ceiling(preferred);

            // 4. Wrap around if no server is found
            if (server == null) {
                server = available.first();
            }

            // 5. Assign request
            available.remove(server);

            count[server]++;

            // 6. Calculate completion time
            busy.offer(new int[]{
                arrival[i] + load[i],
                server
            });
        }

        // 7. Find maximum number of requests
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // 8. Collect busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}