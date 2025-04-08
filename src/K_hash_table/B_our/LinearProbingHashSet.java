package K_hash_table.B_our;

// adapted from: https://courses.cs.washington.edu/courses/cse373/13wi/lectures/01-30/HashSet.java

// OPTIONAL; we did not cover in class.

import java.util.StringJoiner;

public class LinearProbingHashSet<E> implements Set3130<E> {
    private Object[] table;
    private int size;
    private final double maxLoadFactor;

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75;
    private static final Object REMOVED = new Object();

    public LinearProbingHashSet() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public LinearProbingHashSet(int initialCapacity, double maxLoadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initial capacity cannot be negative");
        }

        if (maxLoadFactor <= 0) {
            throw new IllegalArgumentException("max load factor must be positive");
        }

        if (maxLoadFactor > 1) {
            throw new IllegalArgumentException("in LinearProbingHashSet, max load factor cannot be greater than 1");
        }

        table = new Object[initialCapacity];
        size = 0;
        this.maxLoadFactor = maxLoadFactor;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }

        int index = hash(element);

        // perform linear probing until reaching null or REMOVED
        while (table[index] != null && table[index] != REMOVED) {
            index = (index + 1) % table.length;
        }

        table[index] = element;
        size++;

        if (loadFactor() > maxLoadFactor) {
            ensureCapacity(2 * table.length + 1);
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = hash(o);

        while (table[index] != null) {
            if (table[index].equals(o)) {
                table[index] = REMOVED;
                return true;
            }

            index = (index + 1) % table.length;
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        int index = hash(o);

        while (table[index] != null) {
            if (table[index].equals(o)) {
                return true;
            }

            index = (index + 1) % table.length;
        }

        return false;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (Object element : table) {
            if (element != null && element != REMOVED) {
                joiner.add(element.toString());
            }
        }

        return joiner.toString();
    }

    private int hash(Object o) {
        return Math.abs(o.hashCode()) % table.length;
    }

    private double loadFactor() {
        return (double) size / table.length;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newCapacity) {
        Object[] oldTable = table;
        table = new Object[newCapacity];

        for (Object o : oldTable) {
            if (o != null && o != REMOVED) {
                add((E) o);
            }
        }
    }
}