package J_stack_queue_deque.A_stack.D_applications;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A classic stack application.
 */
public class MatchDelimiters {
    public static void main(String[] args) {
        String[] valid = {
                "()(()){([()])}",
                "( ) ( ( ) ) {( [ ( )  ] ) } ",
                "(3) (3 + (4 - 5) ) {( [ ( )  ] ) } ",
                "((()(()){([()])}))",
                "[(5+x)-(y+z)]"
        };

        String[] invalid = {
                ")(()){([()])}",
                "({[])}",
                "([]"
        };

        for (String s : valid) {
            if (!isMatched(s)) {
                System.out.println("Error evaluating valid: " + s);
            }
        }

        for (String s : invalid) {
            if (isMatched(s)) {
                System.out.println("Error evaluating invalid: " + s);
            }
        }
    }

    /**
     * Determines if the delimiters in the given expression are properly matched.
     */
    public static boolean isMatched(String expression) {
        Deque<Character> stack = new ArrayDeque<>(); // or: new LinkedList<>();

        for (char ch : expression.toCharArray()) {
            if (isOpeningDelimiter(ch)) {
                stack.push(ch);
            } else if (isClosingDelimiter(ch)) {
                if (stack.isEmpty()) {
                    return false; // nothing to match with
                }

                if (!matches(stack.pop(), ch)) {
                    return false; // mismatched delimiter
                }
            }

            // for debugging
            // System.out.println(ch + " " + stack);
        }

        return stack.isEmpty(); // were all opening delimiters matched?
    }

    private static boolean isOpeningDelimiter(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isClosingDelimiter(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean matches(char opening, char closing) {
        return opening == '(' && closing == ')'
               || opening == '[' && closing == ']'
               || opening == '{' && closing == '}';
    }
}
