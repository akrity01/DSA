class Solution {
    public int romanToInt(String s) {
        int[] values = new int[26]; // store values of each Roman letter
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = values[s.charAt(i) - 'A'];
            
            if (curr < prev) total -= curr;  // subtractive case
            else total += curr;              // normal case
            
            prev = curr; // update for next iteration
        }

        return total;
    }
}
