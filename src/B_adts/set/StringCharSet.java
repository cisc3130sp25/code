package B_adts.set;

public class StringCharSet implements CharSet {
    private String s = "";

    @Override
    public boolean add(char ch) {
        if (contains(ch)) {
            return false;
        } else {
            s += ch;
            return true;
        }
    }

    @Override
    public boolean remove(char ch) {
        int index = s.indexOf(ch);

        if (index < 0) {
            return false;
        } else {
            s = s.substring(0, index) + s.substring(index + 1);
            return true;
        }
    }

    @Override
    public boolean contains(char ch) {
        return s.indexOf(ch) >= 0;
    }

    @Override
    public int size() {
        return s.length();
    }
}
