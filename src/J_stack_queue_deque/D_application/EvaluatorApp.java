package J_stack_queue_deque.D_application;

import java.util.Scanner;

/**
 * This program prompts for fully-parenthesized arithmetic expressions, and it
 * evaluates each expression. Note: the expression must be fully-parenthesized,
 * e.g., ((2.5+3)+4). Also, the only operators allowed are binary +, -, *, /, and ^.
 * We do not allow unary operators (such as -) here.
 *
 * The algorithm uses two stacks to store intermediate results:
 * one stores numbers and the other stores operators.
 *
 * As we see operators, we push them onto the symbol stack.
 * As we see numbers, we push them onto the number stack.
 * And when we see a right parenthesis, we know we have all the information for
 * a subexpression, so we evaluate it, and push the result onto the number stack.
 *
 * (From Building Java Programs ch. 14, with some modifications.)
 */
public class EvaluatorApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("This program evaluates fully parenthesized expressions");
        System.out.println("with the operators +, -, *, +, and ^");

        System.out.print("expression (return to quit)? ");
        String line = console.nextLine().trim();

        while (!line.isEmpty()) {
            Evaluator evaluator = new Evaluator(line);

            try {
                System.out.println(evaluator.evaluate());
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

            System.out.print("expression (return to quit)? ");
            line = console.nextLine().trim();
        }
    }
}
