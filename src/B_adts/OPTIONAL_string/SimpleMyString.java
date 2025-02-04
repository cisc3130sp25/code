package B_adts.OPTIONAL_string;

import java.util.Arrays;

public class SimpleMyString implements MyString {
    private char[] chars;

    /**
     * Creates a string representation of chars.
     * @param chars
     */
    public SimpleMyString(char[] chars) {
        this.chars = Arrays.copyOf(chars, chars.length); // defensive copy
    }

    @Override public int length() { return chars.length; }

    @Override public char charAt(int i) { return chars[i]; }

    @Override public MyString substring(int start, int end) {
        char[] subArray = Arrays.copyOfRange(chars, start, end);
        return new SimpleMyString(subArray);
    }
}
