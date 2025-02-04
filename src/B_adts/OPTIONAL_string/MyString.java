package B_adts.OPTIONAL_string;

/**
 * MyString represents an immutable sequence of characters.
 */
public interface MyString {
    /**
     * @param chars an array of chars
     * @return a string representation of chars
     */
    static MyString valueOf(char[] chars) {
        return new FastMyString(chars);
    }

    /**
     * @return number of characters in this string
     */
    int length();

    /**
     * @param i character position (requires 0 <= i < string length)
     * @return character at position i
     */
    char charAt(int i);

    /**
     * Get the substring between start (inclusive) and end (exclusive).
     * @param start starting index
     * @param end ending index. Requires 0 <= start <= end <= string length.
     * @return string consisting of charAt(start)...charAt(end-1)
     */
    MyString substring(int start, int end);
}
