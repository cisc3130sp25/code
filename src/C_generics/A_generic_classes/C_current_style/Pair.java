package C_generics.A_generic_classes.C_current_style;

/*
Pair is a generic class.

T is a type parameter. It is a placeholder for an actual type,
which will be specified by the client when they create an object of this class.

Within the Pair class, T can be used as the type of instance fields,
and can be used in constructors and instance methods.
 */
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
}
