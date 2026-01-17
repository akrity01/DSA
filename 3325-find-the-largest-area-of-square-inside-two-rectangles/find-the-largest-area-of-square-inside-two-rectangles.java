class Solution {
    public long largestSquareArea(int[][] bl, int[][] tr) {
        int n = bl.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // Sort by left x
        Arrays.sort(idx, (i, j) -> Integer.compare(bl[i][0], bl[j][0]));

        long best = 0;

        for (int a = 0; a < n; a++) {
            int i = idx[a];

            int ax1 = bl[i][0], ay1 = bl[i][1];
            int ax2 = tr[i][0], ay2 = tr[i][1];

            // Only check rectangles whose left is before ax2
            for (int b = a + 1; b < n && bl[idx[b]][0] < ax2; b++) {

                int j = idx[b];

                // fast Y rejection
                if (tr[j][1] <= ay1 || bl[j][1] >= ay2)
                    continue;

                int xOverlap = Math.min(ax2, tr[j][0]) - bl[j][0];
                int yOverlap = Math.min(ay2, tr[j][1]) - Math.max(ay1, bl[j][1]);

                int side = Math.min(xOverlap, yOverlap);

                if (side > best)
                    best = side;
            }
        }

        return best * best;
    }
}
