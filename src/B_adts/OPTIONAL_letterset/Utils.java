package B_adts.OPTIONAL_letterset;

class Utils {
    static void requireEnglishLetter(char ch) {
        if (!isEnglishLetter(ch)) {
            throw new IllegalArgumentException("English letter required");
        }
    }

    // result is unspecified if ch is not an English letter
    static char toEnglishLowerCase(char ch) {
        return isLowerCaseEnglishLetter(ch) ? ch : (char) (ch + 32);
    }

    // result is unspecified if ch is not an English letter
    static char toEnglishUpperCase(char ch) {
        return isUpperCaseEnglishLetter(ch) ? ch : (char) (ch - 32);
    }

    private static boolean isEnglishLetter(char ch) {
        return isLowerCaseEnglishLetter(ch) || isUpperCaseEnglishLetter(ch);
    }

    private static boolean isLowerCaseEnglishLetter(char ch) {
        return 'a' <= ch && ch <= 'z';
    }

    private static boolean isUpperCaseEnglishLetter(char ch) {
        return 'A' <= ch && ch <= 'Z';
    }
}
