package C_generics.A_generic_classes.D_variations;

import java.math.BigInteger;

/*
If we want a Pair class that will only allow us to create
a pair of Number, a pair of Integer, a pair of BigInteger, etc.,
but not other types of pairs, such as a pair of String,
this is one way to do it.

Note that this class
- is a generic class
- does not inherit from the Pair class.
 */

// "T extends Number" means that
// T must either be Number or a subclass of Number
public class NumberPair1<T extends Number> {
    private final T first, second;

    public NumberPair1(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    // we are taking advantage of the fact that T is either Number
    // or a subclass of Number
    public double sum() {
        return first.doubleValue() + second.doubleValue();
    }

    public static void main(String[] args) {
        NumberPair1<Number> pair = new NumberPair1<>(23.5, new BigInteger("123"));
        Number first = pair.getFirst();
        System.out.println(pair.sum());

        NumberPair1<Integer> integerPair = new NumberPair1<>(1, 2);
        int f = integerPair.getFirst();

        // this is not allowed:
        // NumberPair1<String> pair2 = new NumberPair1<>("a", "b");
    }
}
