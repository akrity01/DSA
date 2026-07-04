class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {

                int diff1 = Math.abs(a - x);
                int diff2 = Math.abs(b - x);

                if (diff1 == diff2) {
                    return a - b;
                }

                return diff1 - diff2;
            }
        );

        for (int num : arr) {
            pq.offer(num);
        }

        List<Integer> ans = new ArrayList<>();

        while (k-- > 0) {
            ans.add(pq.poll());
        }

        Collections.sort(ans);

        return ans;
    }
}