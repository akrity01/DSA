
class Solution {
    public int reverseDegree(String s) {

        int degree = 0;

        for (int i = 0; i < s.length(); i++) {

            // Reverse alphabet position
            int reversePosition = 26 - (s.charAt(i) - 'a');

            // String position (1-indexed)
            int position = i + 1;

            // Add contribution
            degree += reversePosition * position;
        }

        return degree;
    }
}