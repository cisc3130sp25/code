package K_hash_table.B_our;

import java.util.Collection;
import java.util.LinkedList;

public class ChainingHashSet<E> implements Set3130<E> {
    private Collection<E>[] buckets;
    private int size;
    private final double maxLoadFactor; // the highest level that this set's load factor can go. when the load factor goes above this level, we resize

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75;

    public ChainingHashSet() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public ChainingHashSet(int initialCapacity, double maxLoadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initial capacity cannot be negative");
        }

        if (maxLoadFactor <= 0) {
            throw new IllegalArgumentException("max load factor must be positive");
        }

        buckets = (LinkedList<E>[]) new LinkedList[initialCapacity];
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

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        buckets[index].add(element);
        size++;

        if (loadFactor() > maxLoadFactor) {
            ensureCapacity(2 * buckets.length + 1);
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = hash(o);

        if (buckets[index] == null) {
            return false;
        } else if (!buckets[index].contains(o)) {
            return false;
        } else {
            buckets[index].remove(o);
            size--;
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        int index = hash(o);
        return buckets[index] != null && buckets[index].contains(o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int count = 0;

        for (Collection<E> bucket : buckets) {
            if (bucket != null) {
                for (E element : bucket) {
                    sb.append(element);
                    count++;

                    if (count < size) {
                        sb.append(", ");
                    }
                }
            }
        }

        return sb.append("]").toString();
    }

    // given any object, returns the index at which the object belongs
    private int hash(Object o) {
        return Math.abs(o.hashCode()) % buckets.length;
    }

    // returns the current load factor
    private double loadFactor() {
        return size / (double) buckets.length;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newCapacity) {
        Collection<E>[] oldBuckets = buckets;
        buckets = (LinkedList<E>[]) new LinkedList[newCapacity];
        size = 0;

        for (Collection<E> oldBucket : oldBuckets) {
            if (oldBucket != null) {
                for (E element : oldBucket) {
                    add(element);
                }
            }
        }
    }
}