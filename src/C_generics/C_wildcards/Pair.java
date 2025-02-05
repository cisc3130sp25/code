package C_generics.C_wildcards;

import C_generics.A_generic_classes.C_current_style.PositiveInteger;

import java.util.Objects;

public class Pair<T> {
    private T first, second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // Suppose p1 is a Pair<String>, and p2 is another pair.
    // If we say p1.equals(p2), we hope that p2 is also a Pair<String>
    // But the equals method has no way to guarantee this.
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair<?> other = (Pair<?>) o;
            return this.first.equals(other.first)
                   && this.second.equals(other.second);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    /**
     * Copies the values from the other pair into this pair.
     */
    public void copyFrom(Pair<? extends T> source) {
        this.first = source.first;
        this.second = source.second;
    }

    /**
     * Copies the values from this pair into the other pair.
     */
    public void copyTo(Pair<? super T> destination) {
        destination.first = this.first;
        destination.second = this.second;
    }

    // When to use extends, and when to use super?
    // Mnemonic: PECS: producer - extends, consumer - super.

    public static void main(String[] args) {
        // Integer is the type argument here. For this Pair object, T = Integer
        Pair<Integer> integerPair = new Pair<>(89, -90); // autoboxing

        Pair<PositiveInteger> positiveIntegerPair = new Pair<>(
                new PositiveInteger(5), new PositiveInteger(9));

        Pair<Number> numberPair = new Pair<>(34.7845, new PositiveInteger(23));

        numberPair.copyFrom(positiveIntegerPair); // here, T = Number
        System.out.println(numberPair);

        integerPair.copyTo(numberPair); // here, T = Integer
        System.out.println(numberPair);
    }
}