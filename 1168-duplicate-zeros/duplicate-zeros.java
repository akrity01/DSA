class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        // Count zeros that can be duplicated
        for (int num : arr) {
            if (num == 0) zeros++;
        }

        int i = n - 1;
        int j = n + zeros - 1;

        // Traverse from end
        while (i < j) {
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
    }
}
