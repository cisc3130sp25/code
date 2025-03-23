package J_stack_queue_deque.A_stack.C_puzzle;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Write a method that is given a stack of integers
and returns the sum of the stack's elements.

When the method terminates, the stack must
be in the same state that it was originally in.

Constraints:
1. Only use the 5 standard stack operations:
   push(), pop(), peek(), isEmpty(), size().
2. Do not use any auxiliary collections (arrays, ArrayLists, etc.)
   except for a single stack.
 */
public class Puzzle {
    public static int sum(Deque<Integer> stack) {
        Deque<Integer> auxStack = new ArrayDeque<>();
        int sum = 0;

        while (!stack.isEmpty()) {
            int element = stack.pop();
            auxStack.push(element);
            sum += element;
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }

        return sum;
    }
}