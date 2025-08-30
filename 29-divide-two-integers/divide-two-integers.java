class Solution {
    public int divide(int dividend, int divisor) {
 if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == divisor) return 1;
        boolean sign = (dividend >= 0) == (divisor >= 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;
        while (n >= d) {
            int c = 0;
            while (n >= (d << (c + 1))) {
                c++;
            }
            quotient += (1L << c);
            n -= (d << c);
        }
        if (!sign) quotient = -quotient;
        if (quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) quotient;
    }
}
