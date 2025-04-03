package J_stack_queue_deque.D_application;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Evaluator {
    private final String expression;

    public Evaluator(String expression) {
        this.expression = expression;
    }

    public double evaluate() {
        StringSplitter tokens = new StringSplitter(expression);
        Deque<String> operatorStack = new ArrayDeque<>();
        Deque<Double> numberStack = new ArrayDeque<>();

        while (tokens.hasNext()) {
            String token = tokens.next();

            if (token.equals(")")) {
                if (operatorStack.isEmpty() || numberStack.size() < 2) {
                    throw new IllegalArgumentException(expression);
                } else {
                    String operator = operatorStack.pop();
                    double operand2 = numberStack.pop();
                    double operand1 = numberStack.pop();
                    double value = evaluate(operator, operand1, operand2);
                    numberStack.push(value);
                }
            } else if (isOperator(token)) {
                operatorStack.push(token);
            } else if (!token.equals("(")) {  // token should now be a number
                numberStack.push(Double.parseDouble(token));
            }

            // for debugging
            // System.out.printf("%-5s%-20s%-20s%n", token, operatorStack, numberStack);
        }

        if (numberStack.size() != 1 || !operatorStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        } else {
            return numberStack.pop();
        }
    }

    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private static final List<String> OPERATORS = List.of("+", "-", "*", "/", "^");

    // Given an operator (one of +, -, *, /, or ^) and two operands,
    // returns the result of applying the given operator to the given operands.
    private static double evaluate(String operator, double operand1, double operand2) {
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