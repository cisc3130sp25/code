package B_adts.OPTIONAL_string;

import java.util.Arrays;

public class FastMyString implements MyString {
    private char[] chars;
    private int start;
    private int end;

    /**
     * Creates a string representation of chars.
     * @param chars
     */
    public FastMyString(char[] chars) {
        chars = Arrays.copyOf(chars, chars.length);
        start = 0;
        end = chars.length;
    }

    // private constructor, used internally by producer operations.
    private FastMyString(char[] chars, int start, int end) {
        this.chars = chars;
        this.start = start;
        this.end = end;
    }

    @Override public int length() { return end - start; }

    @Override public char charAt(int i) { return chars[start + i]; }

    @Override public MyString substring(int start, int end) {
        return new FastMyString(this.chars, this.start + start, this.start + end);
    }
}