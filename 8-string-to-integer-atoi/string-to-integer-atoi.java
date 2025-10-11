class Solution {
    public int myAtoi(String s) {
        if (s == null) return 0;

        int n = s.length(), i = 0, sign = 1, result = 0;

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;

        // 2. Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Check for overflow before multiplying
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
