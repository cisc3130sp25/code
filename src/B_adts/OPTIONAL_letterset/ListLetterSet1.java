package B_adts.OPTIONAL_letterset;

import java.util.ArrayList;
import java.util.List;

public class ListLetterSet1 implements LetterSet {
    // in this implementation, as each letter is added, we store it in
    // the list of letters, without converting it to upper or lower case

    private final List<Character> letters = new ArrayList<>();

    @Override
    public boolean add(char ch) {
        Utils.requireEnglishLetter(ch);

        if (contains(ch)) {
            return false;
        } else {
            return letters.add(ch);
        }
    }

    @Override
    public boolean remove(char ch) {
        char lower = Utils.toEnglishLowerCase(ch);
        if (letters.contains(lower)) {
            return letters.remove(Character.valueOf(lower));
        }

        char upper = Utils.toEnglishUpperCase(ch);
        if (letters.contains(upper)) {
            return letters.remove(Character.valueOf(upper));
        }

        return false;
    }

    @Override
    public boolean contains(char ch) {
        return letters.contains(Utils.toEnglishUpperCase(ch)) || letters.contains(Utils.toEnglishLowerCase(ch));
    }

    @Override
    public int size() {
        return letters.size();
    }

    @Override
    public String toString() {
        String result = "{";

        for (char ch : letters) {
            result += ch;
        }

        return result + "}";
    }
}
