
class Solution {
    public int minInsertions(String s) {
        int open = 0;  // Unmatched opening parentheses
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // A previous opening parenthesis still needs two ')'
                if (open > 0) {
                    // Nothing to do here; handle closing pairs below
                }
                open++;
            } else {
                // Current ')' needs a matching '(' before it
                if (open == 0) {
                    insertions++;
                    open++;
                }

                // Check whether the next character is also ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    open--;
                    i++; // Consume the second ')'
                } else {
                    // Insert one ')' to complete the required pair
                    insertions++;
                    open--;
                }
            }
        }

        // Each remaining '(' needs two closing parentheses
        return insertions + 2 * open;
    }
}
