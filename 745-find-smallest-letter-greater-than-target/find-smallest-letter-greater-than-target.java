class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        char ans = letters[0];  // Default answer if no greater letter is found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                ans = letters[mid];  // Candidate for answer
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // If target is greater than or equal to the last letter, wrap around
        return (low < letters.length) ? letters[low] : letters[0];
    }
}
