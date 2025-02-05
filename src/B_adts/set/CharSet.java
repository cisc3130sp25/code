package B_adts.set;

/**
 * A set of characters, that is, a collection of characters without duplicates.
 */
public interface CharSet {
    /**
     * Attempts to add ch to this CharSet. Returns false if this CharSet already contains ch.
     * @param ch the character to add
     * @return true if successfully added, false otherwise
     */
    boolean add(char ch);

    /**
     * Attempts to remove ch from this CharSet. Returns false if this CharSet does not contain ch.
     * @param ch the character to remove
     * @return true if successfully removed, false otherwise
     */
    boolean remove(char ch);

    /**
     * Determines whether this CharSet contains ch.
     * @param ch the character to search for
     * @return true if contains ch, false otherwise
     */
    boolean contains(char ch);

    /**
     * Returns the number of characters currently in this set.
     */
    int size();

    /**
     * Returns the number of characters that this set can hold at once.
     */
    int capacity();

    /**
     * Returns a String of the form {chars} containing all the characters in the set.
     */
    @Override String toString();

    /**
     * Determines whether the set is full.
     */
    default boolean isFull() {
        return size() == capacity();
    }

    /**
     * Returns an empty set with an unlimited capacity.
     */
    static CharSet create() {
        return new StringCharSet();
    }

    /**
     * Returns an empty set with the specified capacity.
     */
    static CharSet create(int capacity) {
        return new ArrayCharSet(capacity);
    }
}
