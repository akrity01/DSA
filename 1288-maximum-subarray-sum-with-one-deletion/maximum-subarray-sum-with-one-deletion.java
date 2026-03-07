class Solution {
    public int maximumSum(int[] arr) {

        int noDelete = arr[0];
        int oneDelete = 0;
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {

            oneDelete = Math.max(noDelete, oneDelete + arr[i]);

            noDelete = Math.max(arr[i], noDelete + arr[i]);

            res = Math.max(res, Math.max(noDelete, oneDelete));
        }

        return res;
    }
}