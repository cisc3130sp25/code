package C_generics.A_generic_classes.D_variations;

// using a generic array to store first and second instead of two variables
public class PairUsingArray<T> {
    private T[] items; // we can have a variable of type T[]

    @SuppressWarnings("unchecked") // optional annotation
    public PairUsingArray(T first, T second) {
        // we cannot do this:
        // items = new T[2]; // we cannot create a T[] object

        items = (T[]) new Object[2]; // create Object[], and cast to T[]
        // causes compiler warning (not error), which can be suppressed with annotation

        items[0] = first;
        items[1] = second;
    }

    public T getFirst() {
        return items[0];
    }

    public T getSecond() {
        return items[1];
    }

    @Override
    public String toString() {
        return "(" + items[0] + ", " + items[1] + ")";
    }

    public static void main(String[] args) {
        PairUsingArray<String> stringPair = new PairUsingArray<>("a", "b");
        System.out.println(stringPair);
    }
}