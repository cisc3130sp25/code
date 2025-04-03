package J_stack_queue_deque.D_application;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A StringSplitter breaks up a string into a sequence of tokens using
 * both whitespace and a list of special characters that are each
 * considered tokens. The special characters in this case are used
 * to tokenize an arithmetic expression. For example, the expression:
 *      2*3.8/(4.95-7.8)
 * would be tokenized as
 *      2 * 3.8 / ( 4.95 - 7.8 )
 * even though it has no whitespace to separate these tokens.
 * (From Building Java Programs ch. 14, with some modifications.)
 */
public class StringSplitter {
    // small demo
    public static void main(String[] args) {
        StringSplitter stringSplitter = new StringSplitter("2*3.8/(4.95-7.8)");

        while (stringSplitter.hasNext()) {
            System.out.println(stringSplitter.next());
        }
    }

    private final Queue<Character> characters;
    private String token;

    public static final List<Character> SPECIAL_CHARACTERS = List.of('(', ')', '+', '-', '*', '/', '^');

    public StringSplitter(String line) {
        characters = new LinkedList<>();

        for (int i = 0; i < line.length(); i++) {
            characters.add(line.charAt(i));
        }

        findNextToken();
    }

    public boolean hasNext() {
        return token != null;
    }

    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        String result = token;
        findNextToken();
        return result;
    }

    public String peek() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return token;
    }

    private void findNextToken() {
        while (!characters.isEmpty() && Character.isWhitespace(characters.peek())) {
            characters.remove();
        }

        if (characters.isEmpty()) {
            token = null;
        } else if (SPECIAL_CHARACTERS.contains(characters.peek())) {
            token = String.valueOf(characters.remove());
        } else { // build a token
            StringBuilder sb = new StringBuilder().append(characters.remove());
            boolean done = false;

            while (!characters.isEmpty() && !done) {
                char ch = characters.peek();

                if (Character.isWhitespace(ch) || SPECIAL_CHARACTERS.contains(ch)) {
                    done = true;
                } else {
                    sb.append(characters.remove());
                }
            }

            token = sb.toString();
        }
    }
}