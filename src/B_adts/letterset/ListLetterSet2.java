package B_adts.letterset;

import java.util.ArrayList;
import java.util.List;

public class ListLetterSet2 implements LetterSet {
    // in this implementation, we store the letters in lowercase form,
    // which makes searching for a letter easier

    private final List<Character> lowercasedLetters = new ArrayList<>();

    @Override
    public boolean add(char ch) {
        Utils.requireEnglishLetter(ch);
        ch = Utils.toEnglishLowerCase(ch);

        if (lowercasedLetters.contains(ch)) {
            return false;
        } else {
            return lowercasedLetters.add(ch);
        }
    }

    @Override
    public boolean remove(char ch) {
        ch = Utils.toEnglishLowerCase(ch);
        return lowercasedLetters.remove(Character.valueOf(ch));
    }

    @Override
    public boolean contains(char ch) {
        ch = Utils.toEnglishLowerCase(ch);
        return lowercasedLetters.contains(ch);
    }

    @Override
    public int size() {
        return lowercasedLetters.size();
    }

    @Override
    public String toString() {
        String result = "{";

        for (char ch : lowercasedLetters) {
            result += ch;
        }

        return result + "}";
    }
}
