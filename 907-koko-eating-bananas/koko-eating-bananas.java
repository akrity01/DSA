
class Solution {
    public int canEat(int[] p, int mid) {
        int a = 0;
        for (int i = 0; i < p.length; i++) {
            a += Math.ceil((double)p[i] / mid);
        }
        return a;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        Arrays.sort(piles);
        int high = piles[piles.length - 1];
        
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalH = canEat(piles, mid);

            if (totalH <= h) {
                result = mid; 
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
