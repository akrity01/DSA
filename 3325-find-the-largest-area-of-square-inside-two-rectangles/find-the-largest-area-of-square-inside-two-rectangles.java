class Solution {
    public long largestSquareArea(int[][] bl, int[][] tr) {
        int n = bl.length;
        long best = 0;

        for (int i = 0; i < n; i++) {
            int ax1 = bl[i][0], ay1 = bl[i][1];
            int ax2 = tr[i][0], ay2 = tr[i][1];

            for (int j = i + 1; j < n; j++) {

                // FAST REJECTION
                if (tr[j][0] <= ax1 || bl[j][0] >= ax2 ||
                    tr[j][1] <= ay1 || bl[j][1] >= ay2)
                    continue;

                int xOverlap = Math.min(ax2, tr[j][0]) - Math.max(ax1, bl[j][0]);
                int yOverlap = Math.min(ay2, tr[j][1]) - Math.max(ay1, bl[j][1]);

                int side = Math.min(xOverlap, yOverlap);

                if (side > best)
                    best = side;
            }
        }

        return best * best;
    }
}
