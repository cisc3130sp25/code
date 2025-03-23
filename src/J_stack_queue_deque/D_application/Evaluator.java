package J_stack_queue_deque.D_application;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// We did not cover the code in class, but we did trace the algorithm.

/**
 * This program prompts for fully-parenthesized arithmetic expressions, and it
 * evaluates each expression. Note: the expression must be fully-parenthesized,
 * e.g., ((2.5+3)+4). Also, the only operators allowed are binary +, -, *, /, and ^.
 * We do not allow unary - here.
 *
 * We use a variation of the "shunting-yard algorithm".
 * The algorithm uses two stacks to store intermediate results:
 * one stores numbers and the other stores symbols.
 *
 * As we see left parentheses and operators, we push them onto the symbol stack.
 * As we see numbers, we push them onto the number stack.
 * And when we see a right parenthesis, we know we have all the information for
 * a subexpression, so we evaluate it, and push the result onto the number stack.
 *
 * (From Building Java Programs ch. 14, with some modifications.)
 */
public class Evaluator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("This program evaluates fully parenthesized expressions");
        System.out.println("with the operators +, -, *, +, and ^");

        System.out.print("expression (return to quit)? ");
        String line = console.nextLine().trim();

        while (!line.isEmpty()) {
            evaluate(line);

            System.out.print("expression (return to quit)? ");
            line = console.nextLine().trim();
        }
    }

    // Given a line containing a fully parenthesized expression,
    // prints the value of the expression,
    // or an error message if the expression is not legal.
   public static void evaluate(String line) {
        StringSplitter tokens = new StringSplitter(line);
        Deque<String> symbolsStack = new ArrayDeque<>();
        Deque<Double> valuesStack = new ArrayDeque<>();
        boolean error = false;

        while (!error && tokens.hasNext()) {
            String token = tokens.next();

            if (token.equals(")")) {
                if (symbolsStack.size() < 2 || symbolsStack.peek().equals("(")) {
                    error = true;
                } else {
                    String operator = symbolsStack.pop();

                    if (!symbolsStack.peek().equals("(")) {
                        error = true;
                    } else {
                        symbolsStack.pop(); // to remove the "("
                        double operand2 = valuesStack.pop();
                        double operand1 = valuesStack.pop();
                        double value = evaluate(operator, operand1, operand2);
                        valuesStack.push(value);
                    }
                }
            } else if ("(+-*/^".contains(token)) {
                symbolsStack.push(token);
            } else {  // it should be a number
                valuesStack.push(Double.parseDouble(token));
            }

            // for debugging
            // System.out.printf("%-5s%-20s%-20s%n", token, symbolsStack, valuesStack);
        }

        if (error || valuesStack.size() != 1 || !symbolsStack.isEmpty()) {
            System.out.println("illegal expression");
        } else {
            System.out.println(valuesStack.pop());
        }
    }

    // Given an operator (one of +, -, *, /, or ^) and two operands,
    // returns the result of applying the given operator to the given operands.
    public static double evaluate(String operator, double operand1, double operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "^" -> Math.pow(operand1, operand2);
            default -> throw new RuntimeException("illegal operator " + operator);
        };
    }
}