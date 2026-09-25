
import java.util.*;

class Solution {
    private String s;
    private int i;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        i = 0;

        Set<String> result = parseExpression();

        return new ArrayList<>(new TreeSet<>(result));
    }

    // Handles union: {a,b,c}
    private Set<String> parseExpression() {
        Set<String> result = new HashSet<>();

        result.addAll(parseTerm());

        while (i < s.length() && s.charAt(i) == ',') {
            i++; // Skip comma
            result.addAll(parseTerm());
        }

        return result;
    }

    // Handles concatenation: ab{c,d}e
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (i < s.length()
                && s.charAt(i) != ','
                && s.charAt(i) != '}') {

            Set<String> next = parseFactor();
            Set<String> combined = new HashSet<>();

            for (String a : result) {
                for (String b : next) {
                    combined.add(a + b);
                }
            }

            result = combined;
        }

        return result;
    }

    // Handles a letter or a nested brace expression
    private Set<String> parseFactor() {
        if (s.charAt(i) == '{') {
            i++; // Skip opening brace

            Set<String> result = parseExpression();

            i++; // Skip closing brace
            return result;
        }

        // Single lowercase letter
        char c = s.charAt(i);
        i++;

        Set<String> result = new HashSet<>();
        result.add(String.valueOf(c));

        return result;
    }
}