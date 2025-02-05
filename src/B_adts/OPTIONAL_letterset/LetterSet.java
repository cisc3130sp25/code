package B_adts.OPTIONAL_letterset;

/**
 * A case-insensitive collection of non-duplicate English letters.
 */
public interface LetterSet {
    /**
     * Returns an empty LetterSet.
     */
    static LetterSet create() {
        return new ArrayLetterSet();
    }

    /**
     * Adds the specified letter to the set, rejecting duplicates case-insensitively. For example,
     * if {@code contains('a')} is true, then {@code add('A')} will not add anything.
     * @param ch the letter to add to the set
     * @return true if the addition is successful, false otherwise
     * @throws IllegalArgumentException if ch is not an English letter
     */
    boolean add(char ch);

    /**
     * Removes the specified letter from the set, case-insensitively. For example,
     * if {@code contains('a')} is true, then {@code remove('A')} will be successful.
     * @param ch the letter to remove
     * @return true if a letter was removed, false otherwise
     */
    boolean remove(char ch);

    /**
     * Determines whether the set contains the specified letter, case-insensitively.
     * For example, if {@code add('a')} was just performed, then {@code contains('A')} is true.
     * @param ch the letter to search for
     * @return true if the letter was found, false otherwise
     */
    boolean contains(char ch);

    /**
     * Returns the number of letters in the set.
     */
    int size();

    /**
     * Returns a String containing all the letters of this set.
     * The case is unspecified, and it may be a mixture of lower and upper.
     */
    @Override String toString();

    /**
     * Returns the union of this set and the provided other set.
     * A letter is in the union if it is in this set or the other set.
     */
    default LetterSet union(LetterSet other) {
        LetterSet result = create();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (this.contains(ch) || other.contains(ch)) {
                result.add(ch);
            }
        }

        return result;
    }

    // can have additional set operations: intersection, difference
}

// creators: create, constructors of implementing classes
// producers: union, (additional operations like intersection, difference)
// observers: contains, size, toString
// mutators: add, remove