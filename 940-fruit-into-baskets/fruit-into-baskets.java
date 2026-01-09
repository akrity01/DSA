class Solution {
    public int totalFruit(int[] fruits) {
        int type1 = -1, type2 = -1;   // two basket types
        int count1 = 0, count2 = 0;  // counts of those types
        int max = 0;

        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];

            // If fruit matches one of the basket types
            if (fruit == type1) {
                count1++;
            } 
            else if (fruit == type2) {
                count2++;
            } 
            else if (type1 == -1) {
                type1 = fruit;
                count1 = 1;
            } 
            else if (type2 == -1) {
                type2 = fruit;
                count2 = 1;
            } 
            else {
                // Third type found → shrink window
                while (count1 > 0 && count2 > 0) {
                    int leftFruit = fruits[left];
                    if (leftFruit == type1) count1--;
                    else count2--;
                    left++;
                }

                // One basket is now empty → replace it
                if (count1 == 0) {
                    type1 = fruit;
                    count1 = 1;
                } else {
                    type2 = fruit;
                    count2 = 1;
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
