package B_adts.OPTIONAL_letterset;

public class ArrayLetterSet implements LetterSet {
    // in this implementation, we don't store letters at all;
    // instead, we store a boolean value for each potential letter,
    // indicating whether the letter is present

    private final boolean[] lettersPresent = new boolean[26];

    private static int index(char letter) {
        return 'a' - Utils.toEnglishLowerCase(letter); // TODO verify correctness
    }

    @Override
    public boolean add(char ch) {
        Utils.requireEnglishLetter(ch);

        if (contains(ch)) {
            return false;
        } else {
            lettersPresent[index(ch)] = true;
            return true;
        }
    }

    @Override
    public boolean remove(char ch) {
        if (!contains(ch)) {
            return false;
        } else {
            lettersPresent[index(ch)] = false;
            return true;
        }
    }

    @Override
    public boolean contains(char ch) {
        return lettersPresent[index(ch)];
    }

    @Override
    public int size() {
        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (contains(ch)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        String result = "{";

        for (int i = 0; i < lettersPresent.length; i++) {
            if (lettersPresent[i]) {
                result += ('a' + i);
            }
        }

        return result + "}";
    }
}
