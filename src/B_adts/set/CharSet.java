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
     * @return the number of characters in this set
     */
    int size();

    static CharSet create() {
        return new StringCharSet();
    }
}
