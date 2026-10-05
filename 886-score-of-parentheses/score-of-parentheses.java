import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // score of current level

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Start a new nested level
                stack.push(0);
            } 
            else {
                // Score inside the current parentheses
                int innerScore = stack.pop();

                // () = 1
                // (A) = 2 * A
                int score = (innerScore == 0) ? 1 : 2 * innerScore;

                // Add this score to the outer level
                stack.push(stack.pop() + score);
            }
        }

        return stack.peek();
    }
}