class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int insertions = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    // Need to insert '(' before this ')'
                    insertions++;
                }
            }
        }

        // Remaining '(' need corresponding ')'
        return insertions + open;
    }
}