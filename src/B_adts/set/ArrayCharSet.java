package B_adts.set;

public class ArrayCharSet implements CharSet {
    // Representation: the characters are stored in an array.
    // The capacity is the array's length.
    // The elements are stored at indexes through size - 1.
    // For example, if size is 3, the elements are stored at indexes 0, 1, and 2.
    // We don't care about what's in the array at index size and beyond.

    private final char[] chars;
    private int size;

    /**
     * Creates a set of characters with the specified capacity.
     * @param capacity the number of characters that this set can hold at one time
     */
    public ArrayCharSet(int capacity) {
        chars = new char[capacity];
        size = 0;
    }

    /**
     * {@inheritDoc}
     *
     * This implementation also returns false if the set is full.
     */
    @Override
    public boolean add(char ch) {
        if (isFull() || contains(ch)) {
            return false;
        } else {
            chars[size] = ch;
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(char ch) {
        int index = indexOf(ch);

        if (index < 0) {
            return false;
        } else {
            // copy the last character to index, thus replacing the element we wish to remove.
            // this changes the order of the elements, but that's ok in a set.
            chars[index] = chars[size - 1];
            size--;
            return true;
        }
    }

    @Override
    public boolean contains(char ch) {
        return indexOf(ch) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return chars.length;
    }

    @Override
    public String toString() {
        String result = "{";

        for (int i = 0; i < size; i++) {
            result += chars[i];
        }

        return result + "}";
    }

    private int indexOf(char ch) {
        for (int i = 0; i < size; i++) {
            if (chars[i] == ch) {
                return i;
            }
        }

        return -1;
    }
}
