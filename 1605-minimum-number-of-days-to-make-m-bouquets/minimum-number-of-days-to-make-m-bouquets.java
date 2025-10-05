class Solution {
    // Helper function to check if we can make m bouquets in 'mid' days
    private boolean possible(int[] bloomDay, int mid, int m, int k) {
        int cnt = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= mid) {
                cnt++;
                }
                else {
                     bouquets +=(cnt/ k);
                     cnt= 0 ;
                     }
                     }
                bouquets += ( cnt/k);
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long) m * k;
        if (totalFlowers > bloomDay.length) return -1; // impossible

        int minDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }

        int low = minDay, high = maxDay;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1; // try earlier day
            } else {
                low = mid + 1;  // need more days
            }
        }
        return low;
    }
}
