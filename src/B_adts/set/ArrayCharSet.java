package B_adts.set;

public class ArrayCharSet implements CharSet {
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
            // one way (very good): move last character to index, works since we don't care about order in a set
            // chars[index] = chars[size - 1];

            // another way: shift all characters that are after index to the left by one position
            for (int i = index; i < size - 1; i++) {
                chars[i] = chars[i + 1];
            }

            // these lines are applicable to both approaches:
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

    private int indexOf(char ch) {
        for (int i = 0; i < size; i++) {
            if (chars[i] == ch) {
                return i;
            }
        }

        return -1;
    }

    /**
     * @return the capacity of this set
     */
    public int capacity() {
        return chars.length;
    }

    /**
     * Determines whether the set is full.
     */
    public boolean isFull() {
        return size == capacity();
    }
}
