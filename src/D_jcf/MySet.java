package D_jcf;

/**
 * A set, that is, a collection of elements without duplicates.
 */
public interface MySet<E> extends Iterable<E> {
    /**
     * Attempts to add s to this set. Returns false if this set already contains e.
     * @param e the object to add
     * @return true if successfully added, false otherwise
     */
    boolean add(E e);

    /**
     * Attempts to remove o from this set. Returns false if this set does not contain o.
     * @param o the object to remove
     * @return true if successfully removed, false otherwise
     */
    boolean remove(Object o);

    /**
     * Determines whether this set contains o.
     * @param o the character to search for
     * @return true if this set contains o, false otherwise
     */
    boolean contains(Object o);

    /**
     * @return the number of elements in this set
     */
    int size();

    static <E> MySet<E> create() {
        return new ArrayMySet<>(10);
    }
}

