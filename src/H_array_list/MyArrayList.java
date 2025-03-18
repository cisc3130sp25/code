package H_array_list;

import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    public MyArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
        size = 0;
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        /*
        // the above line is equivalent to the following:
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        */

        return elements[index];
    }

    // O(n)
    @Override
    public void add(int index, E element) {
        Objects.checkIndex(index, size + 1);

        if (isFull()) {
            ensureCapacity(2 * capacity() + 1);
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    private boolean isFull() {
        return size == capacity();
    }

    private int capacity() {
        return elements.length;
    }

    // O(n)
    public void ensureCapacity(int desiredCapacity) {
        if (capacity() < desiredCapacity) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) new Object[desiredCapacity];

            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }

            elements = newArray;

            // the above statements (from the annotation onward) can be replaced with
            // the following statement:
            // elements = Arrays.copyOf(elements, desiredCapacity); // still O(n)
        }
    }

    // O(1), see below
    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }
    /*
     * In most situations, this method requires O(1) steps.
     * In the worst case, when the array needs to be resized,
     * this method requires O(n) steps.
     * Usually when analyzing running time we care about the
     * worst case scenario.
     * However, we will consider this method to have a running
     * time of O(1). Why?
     * Because once we spend O(n) time to double the size of the
     * array, we get to perform about n additions without having
     * to resize the array, and each of those additions takes
     * only O(1) time.
     * In other words, if we call this method n times, it will
     * only use O(n) time in total, not O(n^2) time.
     * This is an example of "amortized analysis."
     *
     * Analogy: Suppose it costs $1,000 to take a course that
     * has 20 sessions; suppose you have to pay for the entire
     * course upfront. How much does it cost per session?
     * One way of looking at it: costs $1,000 for the first session,
     * and then the other sessions are free. So in the worst case,
     * you have to pay $1,000 for a single session. This approach
     * focuses solely on the worst case, ignoring the broader picture.
     * The amortized approach says: Although you have to pay $1,000
     * for the first session, that entitles you 19 free sessions.
     * So think of the $1,000 as being distributed over all 20 sessions,
     * meaning that it costs $50 per session.
     */

    // O(n)
    @Override
    public void clear() {
        // not strictly required, but it is a good idea to set all elements to null,
        // to allow the objects to be deleted if there are no other reference to them
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        size = 0;
    }

    // O(n), but O(n^2) if we would've used String instead of StringBuilder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}