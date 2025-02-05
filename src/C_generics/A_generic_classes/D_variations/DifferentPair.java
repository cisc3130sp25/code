package C_generics.A_generic_classes.D_variations;

public class DifferentPair<T, U> {
    private T first;
    private U second;

    public DifferentPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public static void main(String[] args) {
        DifferentPair<String, Integer> stringIntegerDifferentPair = new DifferentPair<>("a", 67);
        String first = stringIntegerDifferentPair.getFirst();
        int second = stringIntegerDifferentPair.getSecond();

        DifferentPair<String, String> stringStringPair = new DifferentPair<>("a", "b");

        // We can create a DifferentPair where the first and second are different types,
        // and we can create a DifferentPair where the first and second are the same type.
    }
}
