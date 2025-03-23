package J_stack_queue_deque.B_queue.C_puzzles;

import java.util.LinkedList;
import java.util.Queue;

public class Puzzles {
    public static void main(String[] args) {
        int[] data = {18, 4, 7, 42, 9, 33, -8, 0, 14, 42, 7, 42, 42, 19};
        Queue<Integer> q = new LinkedList<>();

        for (int n : data) {
            q.add(n);
        }

        removeAllOccurrences(q, 42);
        System.out.println("q = " + q);
    }

    /*
     Write a method that returns the sum of the elements in the given queue.
     When the method terminates, the queue must be in the same state that it was originally in.
     Constraint: Do not use any auxiliary collections (arrays, ArrayLists, etc.).
    */
    public static int sum(Queue<Integer> queue) {
        int sum = 0;

        for (int i = 0; i < queue.size(); i++) {
            int curr = queue.remove();
            sum += curr;
            queue.add(curr);
        }

        return sum;
    }

    /*
    Write a method that removes all occurrences of the given value in the given queue.
    When the method terminates, all other elements should be in the same order that they were before.
    Constraint: Do not use any auxiliary collections (arrays, ArrayLists, etc.).
     */
    public static void removeAllOccurrences(Queue<Integer> queue, int value) {
        int originalSize = queue.size();

        for (int i = 0; i < originalSize; i++) {
            int element = queue.remove();

            if (element != value) {
                queue.add(element);
            }
        }
    }
}
