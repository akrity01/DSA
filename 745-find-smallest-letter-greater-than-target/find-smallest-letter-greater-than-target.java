class Solution {
    public char nextGreatestLetter(char[] letters, char target) { // letters is a charater array//
        int low = 0, high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // If target is greater than or equal to the last letter, wrap around
        return letters[low % letters.length];
    }
}
