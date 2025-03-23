package J_stack_queue_deque.B_queue.A_our;

import java.util.NoSuchElementException;

/**
 * A queue is a collection of elements that are inserted
 * and removed according to the first-in first-out principle.
 */
public interface Queue<E> {
    /**
     * Returns the number of elements in the queue.
     */
    int size();

    /**
     * Tests whether the queue is empty.
     */
    boolean isEmpty();

    /**
     * Inserts an element at the end of the queue.
     */
    void enqueue(E e); // pronounced N.Q.

    /**
     * Returns, but does not remove, the first element of the queue.
     *
     * @throws NoSuchElementException if the queue is empty
     */
    E peek();

    /**
     * Removes and returns the first element of the queue.
     *
     * @throws NoSuchElementException if the queue is empty
     */
    E dequeue(); // pronounced D.Q.
}
