package J_stack_queue_deque.A_stack.A_our;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Implementation of the stack ADT using a dynamic array.
 * O(1) time for all Stack operations.
 */
public class ArrayStack<E> implements Stack<E> {
    private E[] elements;
    private int indexOfTop; // index of the top element in the stack
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    /**
     * Constructs an empty stack using the default initial capacity.
     */
    public ArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Constructs an empty stack with the given initial capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
        indexOfTop = -1;
    }

    @Override
    public int size() {
        return indexOfTop + 1;
    }
    // O(1)

    @Override
    public boolean isEmpty() {
        return indexOfTop == -1;
    }
    // O(1)

    @Override
    public void push(E e) {
        if (size() == elements.length) {
            elements = Arrays.copyOf(elements, 2 * elements.length + 1);
        }

        elements[++indexOfTop] = e; // increment indexOfTop before storing new item
        // equivalent to:
        // indexOfTop++;
        // elements[indexOfTop] = e;
    }
    // O(1) [amortized]

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return elements[indexOfTop];
    }
    // O(1)

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return elements[indexOfTop--];
    }
    // O(1)

    /**
     * Returns a string representation of the contents of the stack ordered from
     * top to bottom.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("top [");

        for (int i = indexOfTop; i >= 0; i--) {
            sb.append(elements[i]);

            if (i > 0) {
                sb.append(", ");
            }
        }

        return sb.append("] bottom").toString();
    }
    // O(n)
}
