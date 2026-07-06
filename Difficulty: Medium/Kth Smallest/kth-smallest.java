class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i= 0; i<k ;i++)
        {
            pq.offer(arr[i]);
        }
        for (int i = k; i<arr.length;i++)
        {
            if (arr[i]<pq.peek())
            {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        return pq.peek();
    }
}
