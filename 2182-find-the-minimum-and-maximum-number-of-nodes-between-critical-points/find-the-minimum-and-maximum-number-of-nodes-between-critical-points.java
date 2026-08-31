/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;       // position of first critical point
        int prev = -1;        // position of previous critical point
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        int position = 1;

        ListNode prevNode = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            // Check if curr is a critical point
            boolean isMax = curr.val > prevNode.val &&
                            curr.val > curr.next.val;

            boolean isMin = curr.val < prevNode.val &&
                            curr.val < curr.next.val;

            if (isMax || isMin) {

                // First critical point
                if (first == -1) {
                    first = position;
                }

                // We already have a previous critical point
                if (prev != -1) {
                    int distance = position - prev;

                    minDistance = Math.min(minDistance, distance);
                    maxDistance = position - first;
                }

                prev = position;
            }

            prevNode = curr;
            curr = curr.next;
            position++;
        }

        // Fewer than two critical points
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}