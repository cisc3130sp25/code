package C_generics.A_generic_classes.A_without_generics;

public class StringPair {
    private String first, second;

    public StringPair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        StringPair pair = new StringPair("a", "b");
        System.out.println(pair); // (a, b)
        pair.setFirst("c");
        System.out.println(pair.getFirst()); // c
    }
}
